# QMP-Septima-Iteracion

## Enunciado

- [link](https://docs.google.com/document/d/1ERlDghk47Yc1_V1SQ7oCnZAC4bubHx7ZhQXS3naKMJA/edit#)

## Solucion

- Como usuarie de QueMePongo quiero ver todas las prendas que tengo en mi guardarropas desde el navegador para poder 
administrarlas 
  - GET/usuarios/{id}/guardarropas/{id}/prendas
  - no haria falta poner nada en el body del pedido
  - podria devolver 200 indicando que todo salio ok
  - para el codigo 200 devolveria las prendas


- Como usuario de QueMePongo, quiero crear una prenda desde el navegador 
  - POST/usuarios/{id}/guardarropas/{id}/prendas
  - En el body del pedido hace falta: el tipo de prenda, el tipo de material, la trama de la tela, el color primario, 
el color secundario si tiene y la temperatura maxima de uso 
  - podria devolver 201 indicando que se completo el pedido y se creo el recurso
  - para el codigo 201 devolveria la prenda y el id de prenda


- Como usuarie de QueMePongo quiero ver una prenda en particular que tengo en mi guardarropas para poder editarla
  - GET/usuarios/{id}/guardarropas/{id}/prendas/{id}
  - no haria falta poner nada en el body del pedido
  - podria devolver 200 indicando que todo salio ok
  - para el codigo 200 devolveria la prenda solicitada


- Como usuarie de QueMePongo, quiero poder eliminar una prenda de mi guardarropas
  - DELETE/usuarios/{id}/guardarropas/{id}/prendas/{id}
  - no haria falta poner nada en el body del pedido
  - podria devolver 200 indicando que todo salio ok
  - para el codigo 200 no devolveria nada


- Como usuarie de QueMePongo, quiero poder ver mis eventos para administrarlos
  - GET/usuarios/{id}/eventos
  - no haria falta poner nada en el body del pedido
  - podria devolver 200 indicando que todo salio ok
  - para el codigo 200 devolveria los eventos


- Como usuarie de QueMePongo, quiero poder abrir las sugerencias de prendas para un evento en mi navegador
  - GET/usuarios/{id}/eventos/{id}/sugerencias
  - no haria falta poner nada en el body del pedido
  - podria devolver 200 indicando que todo salio ok
  - para el codigo 200 devolveria las sugerencias


---

# Validar el proyecto de forma exahustiva

```
mvn clean verify
```

# Entrega del proyecto

Para entregar el proyecto, crear un tag llamado `entrega-final`. Es importante que antes de realizarlo se corra la validación
explicada en el punto anterior. Se recomienda hacerlo de la siguiente forma:

```
mvn clean verify && git tag entrega-final && git push origin HEAD --tags
```

