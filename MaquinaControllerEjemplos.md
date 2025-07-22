

# Ejmplos de metodos de clase `MaquinaController`




## 🧾 **Listado de Maquinas**

```java
List<Maquina> maquinas = Arrays.asList(
    new Maquina("Servidor1", "192.168.200.15", Arrays.asList(5, 10, 3)),        // subred: 200, riesgo: 120
    new Maquina("Servidor1", "10.0.200.88", Arrays.asList(10, 2)),              // subred: 200, riesgo: 120
    new Maquina("Alpha2", "192.168.100.8", Arrays.asList(25, 1, 3, 10)),        // subred: 100, riesgo: 210
    new Maquina("Beta22", "10.0.250.100", Arrays.asList(5, 5, 5)),              // subred: 250, riesgo: 75
    new Maquina("Beta22", "172.16.250.101", Arrays.asList(10, 5)),              // subred: 250, riesgo: 75
    new Maquina("Base de Datos 1", "10.0.50.99", Arrays.asList(5, 15, 20, 1)),  // subred: 50, riesgo: 320
    new Maquina("ControlBackupX9", "172.16.90.5", Arrays.asList(25, 5, 10)),    // subred: 90, riesgo: 560
    new Maquina("ControlBackupX9", "172.16.99.8", Arrays.asList(5, 10))         // subred: 99, riesgo: 240
);
```

---

## 🔷 Método A: `filtrarPorSubred(maquinas, 100)`

Este método filtra las máquinas cuya subred sea mayor a 100 (ejemplo 100) y las devuelve en una pila en el orden en que aparecen en la lista original.

### 📥 Entrada:

Umbral: `100`

### ✅ Salida esperada (`Stack<Maquina>` de arriba hacia abajo):

1. Beta22 — 172.16.250.101 (subred: 250)
2. Beta22 — 10.0.250.100 (subred: 250)
3. Servidor1 — 10.0.200.88 (subred: 200)
4. Servidor1 — 192.168.200.15 (subred: 200)

---

## 🔷 Método B: `ordenarPorSubred(Stack)`

Este método ordena las máquinas por subred en orden descendente. En caso de que dos máquinas tengan el mismo nombre y subred, solo se conserva una (el `TreeSet` elimina duplicados bajo ese criterio).

### 📥 Entrada:

Stack con:

* Beta22 (250)
* Beta22 (250)
* Servidor1 (200)
* Servidor1 (200)

### ✅ Salida esperada (`TreeSet<Maquina>`):

1. Beta22 (subred: 250)
2. Servidor1 (subred: 200)

---

## 🔷 Método C: `agruparPorRiesgo(maquinas)`

Este método agrupa las máquinas en un `TreeMap` donde la clave es el riesgo calculado y el valor es una cola (`Queue`) con las máquinas que tienen ese riesgo. El mapa queda ordenado de menor a mayor riesgo.

### ✅ Salida esperada (`Map<Integer, Queue<Maquina>>`):

```text
75  → [Beta22, Beta22]
120 → [Servidor1, Servidor1]
210 → [Alpha2]
240 → [ControlBackupX9]
320 → [Base de Datos 1]
560 → [ControlBackupX9]
```

---

## 🔷 Método D: `explotarGrupo(Map)`

Este método encuentra el grupo más numeroso (mayor cantidad de máquinas) y, en caso de empate, elige el que tenga mayor riesgo. Devuelve una pila con esas máquinas en orden invertido (LIFO).

### ✅ Salida esperada (`Stack<Maquina>`):

```text
[Servidor1, Servidor1]
```

---

## 📌 Resumen general de ejecución

| Método | Salida esperada                                                                  |
| ------ | -------------------------------------------------------------------------------- |
| A      | Stack: `[Beta22, Beta22, Servidor1, Servidor1]` (orden de entrada, subred > 100) |
| B      | TreeSet: `[Beta22, Servidor1]` (subred DESC, nombre ASC, sin duplicados)         |
| C      | Map: claves = riesgo, colas agrupadas (algunos con 2 elementos)                  |
| D      | Stack: `[Servidor1, Servidor1]` (grupo más grande con mayor riesgo)              |
