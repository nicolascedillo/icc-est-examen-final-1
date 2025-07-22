package models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Maquina {
    private String nombre;
    private String ip;
    private List<Integer> codigos;
    private int subred;
    private int riesgo;

    public Maquina(String nombre, String ip, List<Integer> codigos) {
        this.nombre = nombre;
        this.ip = ip;
        this.codigos = codigos;
        this.subred = calcularSubred();
        this.riesgo = calcularRiesgo();
    }

    private int calcularSubred(){
        String[] arreglo = ip.split("\\.");
        int tercerOctoteto = Integer.valueOf(arreglo[2]);
        return tercerOctoteto;
    }

    private int calcularRiesgo(){
        int sumaDivisibles = 0;
        for(int n:codigos){
            if(n%5==0){
                sumaDivisibles += n;
            }
        }
        int unicos = calcularCaracteresUnicos();
        return sumaDivisibles*unicos;
    }

    private int calcularCaracteresUnicos(){
        Set<Character> set = new HashSet<>();
        for (char c:nombre.toLowerCase().toCharArray()){
            if(c != ' '){
                set.add(c);
            }
        }
        return set.size();
    }

    @Override
    public String toString() {
        return  nombre + ip + codigos + subred + riesgo ;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIp() {
        return ip;
    }

    public List<Integer> getCodigos() {
        return codigos;
    }

    public int getSubred() {
        return subred;
    }

    public int getRiesgo() {
        return riesgo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + subred;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Maquina other = (Maquina) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (subred != other.subred)
            return false;
        return true;
    }
    
}
