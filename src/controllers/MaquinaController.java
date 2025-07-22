package controllers;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import models.Maquina;

public class MaquinaController {
    
    public Stack<Maquina> filtrarPorSubred(List<Maquina> maquinas, int umbral){
        Stack<Maquina> aux = new Stack<>();
        Stack<Maquina> filtradas = new Stack<>();

        for(Maquina m:maquinas){
            if(m.getSubred() > umbral){
                aux.push(m);
            }
        }

        while (!aux.isEmpty()) {
            filtradas.push(aux.pop());
        }

        return filtradas;
    }

    public Set<Maquina> ordenarPorSubred(Stack<Maquina> pila){

        Comparator<Maquina> comparator = new Comparator<Maquina>() {

            @Override
            public int compare(Maquina o1, Maquina o2) {
                int subred = Integer.compare(o2.getSubred(), o1.getSubred());

                if(subred != 0){
                    return subred;
                }

                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
            
        };
        Set<Maquina> set = new TreeSet<>(comparator);
        
        while(!pila.isEmpty()){
            set.add(pila.pop());
        }

        return set;
    }

    public Map<Integer, Queue<Maquina>> agruparPorRiesgo(List<Maquina> maquinas){


        Map<Integer, Queue<Maquina>> mapa = new TreeMap<>();

        for(Maquina m:maquinas){

            Queue<Maquina> cola = new LinkedList<>();

            if (mapa.containsKey(m.getRiesgo())) {

                Queue<Maquina> cola2 = mapa.get(m.getRiesgo());
                cola2.add(m);
                cola = cola2;

            }else{

                cola.add(m);
            }
            mapa.put(m.getRiesgo(), cola);
        }
        
        return mapa;
    }

    public Stack<Maquina> explotarGrupo(Map<Integer, Queue<Maquina>> mapa){
        Stack<Maquina> aux = new Stack<>();
        Stack<Maquina> stack = new Stack<>();

        int max = 0;

        for (Map.Entry<Integer, Queue<Maquina>> e: mapa.entrySet()){
            if(e.getKey() < max){
                max = e.getKey();
            }
        }

        Queue<Maquina> cola = mapa.get(max);
        while (!cola.isEmpty()) {
            aux.push(cola.poll());
        }

        while (!aux.isEmpty()) {
            stack.push(aux.pop());
        }

        return stack;

    }
}
