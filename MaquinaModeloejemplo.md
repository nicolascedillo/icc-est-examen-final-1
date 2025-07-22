
# Objeto `Maquina`


* El **riesgo** se calcula como:
  👉 *suma de los códigos divisibles por 5* ✖️ *cantidad de **caracteres únicos** en el nombre (exceptuando espacios)*

* La **subred** se obtiene del tercer octeto de la dirección IP (ej. `192.168.200.15` → `200`)

* Los **códigos** son una lista de enteros que pueden incluir números como `5`, `10`, `15`, etc.
* El **nombre** es una cadena de texto que puede contener letras, números y espacios.
---
## Ejemplos de Objetos `Maquina` con Riesgo y Subred como campos Calculados

### ✅ **Ejemplo 1**

```java
new Maquina("Servidor1", "192.168.200.15", Arrays.asList(5, 10, 3))
```

* **Subred**: `200` ← tercer octeto de IP
* **Códigos divisibles por 5**: `5`, `10` → suma = `15`
* **Nombre**: `"Servidor1"`
* **Caracteres únicos**: `{'S','e','r','v','i','d','o','1'}` → 8
* **Riesgo**: `15 * 8 = 120`

---

### ✅ **Ejemplo 2**

```java
new Maquina("Base de Datos 1", "10.0.50.99", Arrays.asList(5, 15, 20, 1))
```

* **Subred**: `50`
* **Códigos divisibles por 5**: `5`, `15`, `20` → suma = `40`
* **Nombre**: `"Base de Datos 1"`
* **Caracteres únicos** (sin espacios):
  `{'B','a','s','e','d','t','o','1'}` → 8
* **Riesgo**: `40 * 8 = 320`

---

### ✅ **Ejemplo 3**

```java
new Maquina("Alpha2", "192.168.100.8", Arrays.asList(25, 1, 3, 10))
```

* **Subred**: `100`
* **Códigos divisibles por 5**: `25`, `10` → suma = `35`
* **Nombre**: `"Alpha2"`
* **Caracteres únicos**: `{'A','l','p','h','a','2'}` → 6
* **Riesgo**: `35 * 6 = 210`

---

### ✅ **Ejemplo 4**

```java
new Maquina("Beta22", "10.0.250.100", Arrays.asList(5, 5, 5))
```

* **Subred**: `250`
* **Códigos divisibles por 5**: `5+5+5 = 15`
* **Nombre**: `"Beta22"`
* **Caracteres únicos**: `{'B','e','t','a','2'}` → 5
* **Riesgo**: `15 * 5 = 75`

---

### ✅ **Ejemplo 5 (máximo riesgo por muchos caracteres únicos)**

```java
new Maquina("ControlBackupX9", "172.16.90.5", Arrays.asList(25, 5, 10))
```

* **Subred**: `90`
* **Suma de divisibles por 5**: `40`
* **Nombre**: `"ControlBackupX9"`
* **Caracteres únicos**:
  `{'C','o','n','t','r','l','B','a','c','k','u','p','X','9'}` → 14
* **Riesgo**: `40 * 14 = 560`

