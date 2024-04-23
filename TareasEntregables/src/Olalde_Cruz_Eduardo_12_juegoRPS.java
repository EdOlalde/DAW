//Importación de la utilidad Scanner para poder recoger datos por teclado
import java.util.Scanner;
public class Olalde_Cruz_Eduardo_12_juegoRPS {

	public static void main(String[] args) {
		 //Establecimiento del scanner de recogida de datos por teclado que permite recoger las elecciones de los jugadores
		Scanner teclado = new Scanner(System.in);
		
		//Declaración e inicialización de las variables necesarias para el juego.
		//Varibles de tipo char ya que el juego sólo requiere recoger un único caracter por cada elección.
		//Durante todo el programa se creará cada variable con un nombre descriptico y el número de jugador asociado a
		//la variable.
		char jugada1;
		jugada1 = ' ';
		char jugada2;
		jugada2 = ' ';
		
		//Declaración de variables tipo int para llevar un conteo de los puntos de cada jugador,
		//e inicialización a 0 puntos porque calcularé el ganador comparándolas para ver quién ha conseguido más puntos.
		int puntos1;
		puntos1 = 0;
		int puntos2;
		puntos2 = 0;
		
		//Declaración e inicialización de variables tipo String para los nombres de los jugadores que luego se pedirán por consola
		//y mostrarán a lo largo del programa.
		String nombre1;
		nombre1 = "";
		String nombre2;
		nombre2 = "";
		
		//Para mostrar cada jugada por consola, declaro dos variables que tendrán asignadas el 
		//nombre completo de la elección de los jugadores.
		String nombreDecision1;
		nombreDecision1 = "";
		String nombreDecision2;
		nombreDecision2 = "";
		
		
		//Muestro mediante la función "system.out.println" (en adelante syso"s) por consola el texto con la explicación de las reglas 
		//del juego y el funcionamiento del programa para que los usuarios tengan toda la información.
		//Primero indico las reglas del juego
		System.out.println("Vamos a jugar a piedra, papel, tijeras, al mejor de 3 rondas.");
		System.out.println("Ya sabéis las reglas, pero por si acaso las recuerdo. "
				+ "Papel gana a piedra, piedra gana a tijera, y tijera gana a papel.");
		//Seguidamente indico las instrucciones para usar el programa.
		System.out.println("Para elegir hay que introducir una letra en mayúsculas y pulsar enter. "
				+ "Para papel introducid P (paper), para tijeras S (scissors), y para piedra R (rock).\n");
		
		//Texto por consola para pedir los nombres de los jugadores.
		System.out.println("Introduce el nombre del jugador 1: ");
		
		//Usando el Scanner creado antes, recojo por teclado del nombre del jugador 1, 
		//usando next.Line porque se quiere recoger un String de varios caracteres.
		nombre1 = teclado.nextLine();
		
		//Repetimos para el jugador 2.
		System.out.println("Introduce el nombre del jugador 2: ");
		nombre2 = teclado.nextLine();
		
		//Establezco de un bucle for que empieza en 0 y se cumple mientras i sea menor o igual que 2 para 
		//crear 3 bucles, y opor lo tanto repetir 3 veces el juego.		
		//Inicializo i en 1 en lugar de 0 porque usaré la variable para mostrar la ronda actual en pantalla.
		for(int i=1; i<=3; i++)
		{
			//Empezamos el juego.
			
			
			System.out.println("Ronda número " + i + ". ¡Piedra, papel, tijeras, 1, 2, 3!");
			
			//Recogida de datos	
			
			//Establezco un bucle for (porque no me dejas usar do while) para que en caso de que el jugador no elija 
			//una de las letras permitidas, le muestre un mensaje con el error y le vuelva a pedir la elección.
			//Utilizo j como variable de iteración porque estoy dentro de otro bucle for que usa la i.
			//Puesto que las variables del juego son primitivas tipo char, se pueden utilizar operadores lógicos para compararlas,
			//y así lo haré durante el resto del programa.
			
			for(int j = 0; j < 9999; j++)
			{
				//Recojo la elección del jugador por teclado después de indicar que es su turno mediante texto
				//Para ello uso un syso en el que concateno el texto que quiero mostrar con la variable del nombre del jugador 1
				//usando +, igual que concatenaré de ahora en adelante cada vez que necesite mostrar el nombre de un jugador
				//o de una jugada.
				System.out.println("Jugada de " + nombre1);
				jugada1 = teclado.next().charAt(0);
				
				//Para saber si el jugador ha elegido una jugada permitida, uso una estructura if/else que evalúe la letra
				//introducida por teclado.
				//Si la letra no es P, R, o S, se muestra el mensaje de error y se repite el bucle, volviendo a pedir la elección
				//(y entre paréntesis el número restante de intentos antes de que acabe el bucle for).
				if(jugada1 != 'P' && jugada1 != 'R' && jugada1 != 'S')
				{
					System.out.println("Las opciones sólo pueden ser P, R o S, vuelve a elegir (quedan " + (9999-j) + " intentos): ");
				}
				//En caso contrario, que el jugador haya elegido una de las 3 letras permitidas, fuerzo el final del 
				//bucle haciendo que la variable de iteración j esté fuera del rango de repetición.
				
				else
				{
					j = 9999;
				}								
			}
			//Creo una estructura if/else if basada en la elección del jugador que asigne a la variable NombreDecision el nombre
			//de la jugada para usarla más tarde al mostrar qué jugada han elegido los jugadores.
			//Creo la estructura una vez acabado el anterior bucle for porque sólo necesita ejecutarse una vez,
			//cuando la decisión ya ha sido tomada.
			if(jugada1 == 'P')
			{
				nombreDecision1 = "papel";
			}
			else if(jugada1 == 'R')
			{
				nombreDecision1 = "piedra";
			}
			//Sólo queda la posibilidad de que sea tijeras puesto que no se ha podido seleccionar una opción no válida 
			//gracias a la estructura for anterior, así que no hace falta poner otro if con su condición, sólo el else con la
			//única posibilidad restante.
			else
			{
				nombreDecision1 = "tijeras";
			}
			
		
			//Repetimos las estructuras  anteriores para el jugador 2, cambiando los nombres de las variables
			//por las que están asociadas al jugador 2. Puedo volver a usar la variable j como
			//variable de iteración porque el bucle anterior ya ha finalizado, y por lo tanto j ha dejado de estar definida.
			
			for(int j = 0; j < 9999; j++)
			{
				System.out.println("Jugada de " + nombre2);
				jugada2 = teclado.next().charAt(0);
				
				if(jugada2 != 'P' && jugada2 != 'R' && jugada2 != 'S')
				{
					System.out.println("Las opciones sólo pueden ser P, R o S, vuelve a elegir (quedan " + (9999-j) + " intentos): ");
				}
				else
				{
					j = 9999;
				}								
			}
			if(jugada2 == 'P')
			{
				nombreDecision2 = "papel";
			}
			else if(jugada2 == 'R')
			{
				nombreDecision2 = "piedra";
			}
			else
			{
				nombreDecision2 = "tijeras";
			}
			
			//Para la funcionalidad del juego en sí, necesito evaluar cada caso dadas las elecciones de los jugadores y
			//las reglas del juego. Para ello, usaré una estructura if/else if, que me permitirá mostrar el texto con el ganador
			//además de sumar sus puntos dependiendo de las elecciones de los jugadores.
			//En cada opción se muestra por consola quién ha sido el ganador, y se suma un punto a su variable de conteo de ganador.
			
			//En caso de que las decisione sean iguales, quiere decir que hay un empate. 
			//Se muetra por consola qué ha elegido cada jugador y que hay empate, y no se modifican las variables de conteo de puntos.
			
			if(jugada1 ==  jugada2)
			{
				System.out.println("Los dos habéis elegido " + nombreDecision1 + ". !Empate!\n");
			}
			
			//En el siguiente else if agrupo los casos en los que gana el jugador 2. 
			//Estos casos son en los que J1 juega Papel y J2 juega Tijeras, J1 juega Piedra y J2 juega Papel, o 
			//J1 juega Tijeras y J2 juega Piedra. Ya que el mensaje a mostrar y suma de puntos es la misma para los 3 casos,
			//en lugar de hacer un else if separado para cada caso, los junto todos en el mismo caso if usando paréntesis,
			//separando los 3 casos distintos con un operador "or" (puesto que estoy comprobando
			//si se da uno de esos tres casos en los que gana el jugador 2).
			//Se muestra qué jugadas han elegido los jugadores, que gana el jugador 2, y se le suma un punto.
			else if((jugada1 == 'P' && jugada2 == 'S') || 
					(jugada1 == 'R' && jugada2 == 'P') || (jugada1 == 'S' && jugada2 == 'R'))
			{
				//Escribo por consola el mensaje que muestra la elección de cada jugador y quién gana.
				System.out.println(nombre1 + " elije " + nombreDecision1 + ". " 
			+ nombre2 + " elije " + nombreDecision2 + ". ¡Gana " + nombre2 + "!\n");
				
				//Sumo un punto al jugador haciendo que la variable asignada al conteo de sus puntos suba 1 con la función ++.
				puntos2++;
			}
			
			//Los únicos casos restantes posibles son en los que gana el jugador 1, así que no hace falta escribir 
			//un nuevo if con las condiciones y simplemente uso el else.
			//De nuevo, muestro la jugada elegida por los jugadores, y luego sumo un punto al jugador 1 haciendo que la 
			//variable asignada a su conteo de puntos suba 1.
			else
			{
				System.out.println(nombre1 + " elije " + nombreDecision1 + ". " 
						+ nombre2 + " elije " + nombreDecision2 + ". ¡Gana " + nombre1 + "!\n");
				puntos1++;
			}
			
		}
		
		//Terminado el bucle for de la partida, evaluamos cuántos puntos tiene cada jugador
		//y mostramos el ganador de las tres rondas del juego.
		if(puntos1 == puntos2)
		{
			System.out.println("¡Tenemos un empate!");
		}
		else if(puntos1 < puntos2)
		{
			System.out.println("Y el ganador es... ¡" + nombre2 + "!");
		}
		else
		{
			System.out.println("Y el ganador es... ¡" + nombre1 + "!");
		}
		
		
		
		
		
		//Cerrado del scanner de recogida de datos por consola.
		teclado.close();
		
	}

}
