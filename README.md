<h1 align="center">DESAFÍO: CONVERSOR DE MONEDAS</h1>

El proyecto consiste en elaborar un sistema capaz de realizar conversiones de monedas con opciones ya establecidas, como también especificar las divisas que se desean convertir.
El sistema no permite la utilización de otras opciones inexistentes, lo que favorece a cumplir con su finalidad.

<h2>Demostración</h2>

El contenido principal que se muestra al ejecutar la aplicación es el siguiente:

![image](https://github.com/user-attachments/assets/25c43cd0-5eba-4ac2-b9e9-c43f994f31aa)

Las opciones del 1 al 6 permiten convertir monedas ya establecidas. En caso de la opción 7 permite convertir monedas específicas que el usuario desea, con la única condición de que el código ISO de las monedas estén bien escritas, ya que si no lo están, el programa mostrará una excepción.
Una vez escogida la opción, en caso de no ser la 7, la aplicación solicita el monto a convertir. Este monto debe ser positivo y real:

![image](https://github.com/user-attachments/assets/90a8e742-a4dd-4965-a08f-00948149aacc)

Si se ingresa un monto 0, negativo o imaginario, el programa arrojará una Excepción:

![image](https://github.com/user-attachments/assets/cc56fa70-141a-4a52-9e4a-ca3ce4b9f7f9)

Cuando se escoje la opción 7, ingresamos ISOs válidas:

![image](https://github.com/user-attachments/assets/17d0638f-7d2b-492a-8e7d-238695b15ab7)

En caso de no ingresar alguna ISO válida:

![image](https://github.com/user-attachments/assets/f1220ea3-bb83-4f5e-913c-6acdd0e48f9e)

Todas las conversiones que el usuario realiza son almacenadas en un historial llamado `conversion.json`:

![image](https://github.com/user-attachments/assets/36165aba-9429-44e4-baab-386e54a4fb5f)

<h2>Características de la aplicación</h2>

El sistema se divide en tres paquetes: modulos, logica y principal

<h3>modulos</h3>
<p>En este paquete se encuentran las clases que sirven de base:</p>
<ul>
  <li>
    <strong>Moneda</strong>
    <p>Esta clase es de tipo <code>Record</code>, con los atributos <code>String base</code>, <code>String objetivo</code> y <code>double tasa</code>. Estos atributos nos permiten consultar las divisas y tasas de cambio.</p>
  </li>
  <li>
    <strong>ObtenerMoneda</strong>
    <p>Esta clase contiene un único método llamado <code>getMoneda</code> de tipo <code>Moneda</code>. Este método sirve para extraer el contenido de interés de la API <code>ExchangeRate</code>, necesario para las conversiones y valores iniciales.</p>
  </li>
  <li>
    <strong>GeneradorArchivoJSON</strong>
    <p>Esta clase, al igual que la anterior, posee solamente un método que genera los archivos <code>.json</code> y almacena los cambios.</p>
  </li>
</ul>

<h3>logica</h3>
<p>En este paquete se encuentra la clase que hace los cálculos de conversión.</p>
<ul>
  <li>
    <strong>ConversorDeMonedas</strong>
    <p>Esta clase posee como parámetros String monedaBase, String monedaObjetivo y double monto que se utilizarán para obtener la moneda, invocando el método de la clase ObtenerMoneda</p>
  </li>
</ul>

<h3>principal</h3>
<p>Este paquete contiene la clase principal que hace que la aplicación funcione.</p>

<h2>Acceso</h2>
El presente proyecto puede ser accedido solamente por GitHub. Es libre y puede ser usado por otros usuarios con fines de aprendizaje o mejoramiento.
