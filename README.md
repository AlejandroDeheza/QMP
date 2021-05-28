# QMP-Quinta-Iteracion

## Diagrama de clases - REQUERIMIENTOS DE ESTA ITERACION

<p align="center"> 
<img src="diagramas/qmp5.png">
</p>


## Pseudocodigo

~~~

class Guardarropa {

  String criterioGuardarropa
  List<Prenda> prendas;
  
  agregarPrenda(Prenda prenda) {
    prendas.add(prenda)
  }
  
  quitarPrenda(Prenda prenda) {
    prendas.remove(prenda)
  }
}

Interface PropuestaGuardarropa {
    
    void aplicar()
    void deshacer()
}

class AgregarPrenda {

    Guardarropa guardarropa;
    Prenda prenda;

    public AgregarPrenda(Guardarropa guardarropa, Prenda prenda) {
    this.guardarropa = guardarropa;
    this.prenda = prenda;
    }
    
    void aplicar() {
        guardarropa.agregarPrenda(prenda)
    }
    
    void deshacer() {
        guardarropa.quitarPrenda(prenda)
    }
}

class QuitarPrenda {

    Guardarropa guardarropa;
    Prenda prenda;

    public QuitarPrenda(Guardarropa guardarropa, Prenda prenda) {
    this.guardarropa = guardarropa;
    this.prenda = prenda;
    }
    
    void aplicar() {
        guardarropa.quitarPrenda(prenda)
    }
    
    void deshacer() {
        guardarropa.agregarPrenda(prenda)
    }
}


class Usuario {

  List<Guardarropa> guardarropas;
  List<PropuestaGuardarropa> propuestas;
  
  agregarGuardarropaCompartido(Guardarropa guardarropa) {
    guardaropas.add(guardarropa)
  }
  
  agregarPropuesta(PropuestaGuardarropa propuesta) {
    propuestas.add(propuesta)
  }
  
  getPropuestas() {
    return propuestas
  }
  
  aceptarPropuesta(PropuestaGuardarropa propuesta) {
    propuesta.aplicar
  }
  
  rechazarPropuesta(PropuestaGuardarropa propuesta) {
    propuestas.remove(propuesta)
  }
  
  deshacerPropuesta(PropuestaGuardarropa propuesta) {
    propuestas.deshacer()
  }
}  

~~~

---


# Ejecutar tests

```
mvn test
```

# Validar el proyecto de forma exahustiva

```
mvn clean verify
```

Este comando hará lo siguiente:

 1. Ejecutará los tests
 2. Validará las convenciones de formato mediante checkstyle
 3. Detectará la presencia de (ciertos) code smells
 4. Validará la cobertura del proyecto

# Entrega del proyecto

Para entregar el proyecto, crear un tag llamado `entrega-final`. Es importante que antes de realizarlo se corra la validación
explicada en el punto anterior. Se recomienda hacerlo de la siguiente forma:

```
mvn clean verify && git tag entrega-final && git push origin HEAD --tags
```

