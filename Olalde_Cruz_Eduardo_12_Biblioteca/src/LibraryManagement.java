import java.util.Scanner;

/**
 * Class meant to showcase Publication and Library type objects, providing a menu that allow the creation and login of users,
 * as well as the user of a Library by a User.
 * @see Publication
 * @see User
 * @see Library
 * 
 * @author Eduardo Olalde
 * 
 * @version 0.1
 */
public class LibraryManagement {

	/**
	 * Main class that runs the code necessary for LibraryManagement
	 */
	public static void main(String[] args) {
		
		// Declaración e inicialización de las variable que serán usadas durante el programa
		boolean found = false;
		String username = " ";
		String password = " ";
		String auxString = " ";
		boolean loggedIn = false;
		int counter = 0;
		int selection = -1;
		int selectionLogin = -1;
		Scanner keyboard = new Scanner(System.in);
		
		// Creación de una variable auxiliar que será usada como contenedor temporal para
		// para la búsqueda de Publications en base a alguno de sus atributos
		Publication publicationHolder;
				
		// Creación de una variable tipo User con un objeto vacío que se usará para asignarle el usuario
		// que haga login.
		User currentUser = new User();
				
		// Instanciación de un objeto tipo Library con una capacidad al azar
		Library library = new Library(300);
		
		// Y una segunda biblioteca que hará de referencia para saber qué Publications
		// han sido tomadas prestadas.
		Library borrowedLibrary = new Library(300);
		
		// Declaración de un array que contendrá Users
		User[] users = new User[200];
				
		// Instanciación de dos Users, uno directamente asignado al array anterior y otro a una variable,
		// con el que pruebo el método set de User
		users[0] = new User("john", "pass");
		
		User user1 = new User();
		user1.setUsername("jane");
		user1.setPassword("1234");
		
		// Añado el usuario anterior al array
		users[1] = user1;
		
		
		// Instanciación de varios Books y Magazines que son añadidos directamente a la Library
		
		library.addPublication(new Book("To Kill a Mockingbird", "Harper Lee", "Southern Gothic", 281));
		library.addPublication(new Book("Dune", "Frank Herbert", "Science fiction", 632));
		library.addPublication(new Book("Dune Messiah", "Frank Herbert", "Science fiction", 256));
		library.addPublication(new Book("Children of Dune", "Frank Herbert", "Science fiction", 444));
		
		library.addPublication(new Magazine("HOLA", "HOLA S.L", 245, "05-04-2024"));
		library.addPublication(new Magazine("Motorsport", "Motorsport Network", 137, "05-01-2023"));
		
		// Instanciación de un Book y un Magazine asignados a variables y prueba de setters
		Book b001 = new Book();
		b001.setTitle("War and Peace");
		b001.setAuthor("Leo Tolstoy");
		b001.setGenre("Historical novel");
		b001.setNumPages(1225);
		library.addPublication(b001);
		
		Magazine m001 = new Magazine();		
		m001.setTitle("El Jueves");
		m001.setAuthor("RBA Revistas");
		m001.setIssueNumber(398);
		m001.setPublishDate("01-05-2024");
		library.addPublication(m001);
		
		
		library.searchAuthorsAvailable();
		
		// Menú de login mediante un bucle que pide números al usuario
		// hasta que introduce uno válido mediante un bucle do/while
		do
		{
			System.out.println("\nLogin\n");
			System.out.println("1 - Create account");
			System.out.println("2 - Log into existing account");
			System.out.println("0 - Exit");
			
			System.out.print("\nChoose a number: ");
			selectionLogin = keyboard.nextInt();
			if(selectionLogin < 0 || selectionLogin > 2)
			{
				System.out.println("Invalid option.");
			}	
			keyboard.nextLine();
			
			// En base a la selección del usuario se ejecuta un switch
			switch(selectionLogin)
			{
				case 0:
					// Mensaje de salida
					System.out.println("Exiting library.");
					break;
			
				// En caso de la opción 1 se permite crea un usuario pidiendo el nombre de usuario
				// y contraseña, y se crea un objeto usuario con esos datos asignado al array que contiene
				// todos los usuarios en la primera celda vacía.
				case 1:
					System.out.println("Choose a name: ");
					username = keyboard.nextLine();
					
					found = false;
					
					for(int i=0; i < users.length && found == false; i++)
					{
						if(users[i] != null && users[i].getUsername().equals(username))
						{
							System.out.println("Username already exists.");
							found = true;
						}
					}
					
					if(found == false)
					{
						for(int i=0; i < users.length && found == false; i++)
						{
							if(users[i] == null)
							{
								System.out.println("\nChoose a password: ");
								password = keyboard.nextLine();
								
								users[i] = new User(username, password);
								found = true;
							}
						}
						
					}
					
					break;
				
				// En el caso de la opción 2 se ejecuta un login sencillo. Se pide al usuario un nombre de usuario
				// que luego se busca entre todos los usuario disponibles. Si no se encuentra se vuelve al menú.
				// Si se encuentra, se pide la contraseña y se comprueba si es correcta mediante el método checkPassword.
				// Si no es correcta se vuelve a solicitar mediante un bucle do/while, hasta un máximo de 5 intentos, tras
				// lo cual acaba el bucle y se vuelve al menú.
				case 2:
									
						found = false;
						System.out.println("\nLogin\n");
						System.out.println("Username: ");
						username = keyboard.nextLine();
						for(int i=0; i < users.length && found == false; i++)
						{
							if(users[i] != null && users[i].getUsername().equals(username))
							{
								currentUser = users[i];
								found = true;
							}
						}
						if(found == false)
						{
							System.out.println("User not found.");
						}
						
						// Petición de contraseña si se ha encontrado el nombre de usuario
						if(found == true)
						{
							//Reinicio de la variable counter
							counter = 0;
							do
							{
								// Reinicio de las variables auxiliar found
								found = false;
								//Aumento del contador que limita el número de intentos
								counter++;
								System.out.println("Password: ");
								password = keyboard.nextLine();
								
								// Si la contraseña introducida es válida, se modifican las variables
								// que finalizan el bucle y dan acceso al menú de la biblioteca
								if(currentUser.checkPassword(password) == true)
								{
									System.out.println("\n" + currentUser.getUsername() + " has logged in.");
									found = true;
									loggedIn = true;
								}
								// En caso contrario se notifica
								else 
								{
									System.out.println("Invalid password, you have " + (5 - counter) + " more tries.");
								}	
								// Llegado al límite de intentos se notifica la vuelta al menú
								if(counter >= 5)
								{
									System.out.println("Exiting to menu.");
								}
							}
							while(found == false && counter < 5);
							break;
						}
					
			}
			
			// Si un usuario está logeado tras el menú anterior se accede al menú de la biblioteca
			if(loggedIn == true)
			{

				// Menú general
				do
				{
					
					System.out.println("\nPress enter to continue.");
					keyboard.nextLine();
					
					System.out.println("\nLibrary\n");
					System.out.println("1 - Get a list of the authors available");
					System.out.println("2 - Search publications by author");
					System.out.println("3 - Get a recomendation");
					System.out.println("4 - Borrow publication");
					System.out.println("5 - Return publication");
					System.out.println("0 - Logout");
					System.out.print("\nChoose a number: ");
					
					selection = keyboard.nextInt();
					if(selection < 0 || selection > 4 )
					{
						System.out.println("Invalid option.");
					}
				
					keyboard.nextLine();
				
					switch(selection)
					{
					// Mensaje de logout.
					case 0:
						System.out.println("Logging out.");
						break;
						
					// En esta opción se proporciona el nombre de todos los autores en la biblioteca
					// mediante el método searchAuthorsAvailable
					case 1: 
						found = false;
						System.out.println("Authors available in the library: ");
				    	for(int i=0; i < library.getAvailablePublications().length && found == false; i++)
				    	{
				    		if(library.searchAuthorsAvailable()[i] == null)
				    		{
				    			found = true;
				    		}
				    		else
				    		{
				    			System.out.println(" - " + library.searchAuthorsAvailable()[i]);
				    		}
				    	}
				    	
				    	break;
					
					// En esta opción se pide por consola introducir un nombre de autor y se utiliza
					// para buscar sus publicaciones en la biblioteca mediante el método 
					// searchPublicationsByAuthor
					case 2: 
						System.out.println("Write the name of the author you wish to search: ");
						auxString = keyboard.nextLine();	
						library.searchPublicationsByAuthor(auxString);
						break;
					
					// Opción que lleva al método getRecommendedPublications, que a su vez usa el método
					// toString
					case 3: 
						
						currentUser.getRecommendedPublications(library);
						break;
						
					// En la opción de pedir prestado se pide un título al usuario, y se almacena en la variable auxiliar
					// la publicación correspondiente al título que se ha introducido. 
					case 4: 
						System.out.println("What's the title of the publication you wish to borrow?: ");
						auxString = keyboard.nextLine();
						publicationHolder = library.getPublicationByTitle(auxString);
						
						// A continuación se añade la publicación a la que corresponde en la biblioteca de libros prestados.
						// En caso de que el título no exista en la biblioteca general, el método getPublicationByTitle devuelve 
						// un Book vacío, por lo que se crea un condicional para que, en caso de que el Book contenido en 
						// publicationHolder sea un libro vacío, no se añada a la lista de publicaciones prestadas.
						if(publicationHolder.getTitle() != " ")
						{
							borrowedLibrary.addPublication(publicationHolder);
						}
												
						// Finalmente se ejecuta el método que elimina la publicación de las disponibles.
						library.lendPublication(currentUser, publicationHolder);
						
						// Al acabar el proceso se vacía la variable de publicationHolder para evitar posibles problemas
						publicationHolder = null;
						break;
					
					// En la opción de devolver libro, se pide un título al usuario que si se encuentra en la biblioteca de préstamos,
					// se elimina de esta y se añade a la biblioteca de libros disponibles mediante el método returnPublication.
					case 5:
						System.out.println("What's the title of the publication you wish to return?: ");
						auxString = keyboard.nextLine();
						
						// Se comprueba si el título introducido por el usuario existe tanto en su lista de leídos como
						// en la bilbioteca de préstamos. Si existe en ambos, se acepta la devolución, añadiendo
						// la publicación a la biblioteca de disponibles y eliminándola de la biblioteca de préstamos
						if(currentUser.searchPublicationsByTitle(auxString) == true &&
								borrowedLibrary.searchPublicationsByTitle(auxString) == true)
						{
							publicationHolder = borrowedLibrary.getPublicationByTitle(auxString);
							library.returnPublication(currentUser, publicationHolder);
							borrowedLibrary.removePublication(publicationHolder);
							System.out.println("\n" + currentUser.getUsername() + " has returned " + publicationHolder.getTitle() + 
									" by " + publicationHolder.getAuthor() + " to the library");
							
						}
						else if(borrowedLibrary.searchPublicationsByTitle(auxString) == false)
						{
							System.out.println("There was an error: That publication is not in the borrowed list.");
						}
						else
						{
							System.out.println("There was an error. " + auxString + " wasn't borrowed by " + currentUser.getUsername());
						}
					
						break;
					}
					
				}
				while(selection != 0);
				
				//Reinicio de la variable loggedIn 
				loggedIn = false;
			
			}
		
		}
		while(selectionLogin != 0);
		
		keyboard.close();
	}

}
