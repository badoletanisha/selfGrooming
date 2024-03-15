package com.jsp.hibernat.Hibernateproject_Actor_Moviedb_ManyToMany;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	
        ActorService ac = new ActorService();
        Scanner sc =new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("1. Add Actor");
            System.out.println("2. Find Actor by Name");
            System.out.println("3. Find Actor by Industry");
            System.out.println("4. Find Actor by Movie Title");
            System.out.println("5. Find All Actors Between Age");
            System.out.println("6. Update Actor Age by ID");
            System.out.println("7. Update All Actor Industry by Address");
            System.out.println("8. Delete Actor by Name");
            System.out.println("9. Delete All Actor by Movies Name");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    ac.addActor();
                    break;
                case 2:
                    ac.findActorByName();
                    break;
                case 3:
                    ac.findActorByIndustry();
                    break;
                case 4:
                    ac.findActorByMovieTitle();
                    break;
                case 5:
                    ac.findAllActorsBetweenAge();
                    break;
                case 6:
                    ac.updateActorAgeById();
                    break;
                case 7:
                    ac.updateAllActorIndustryByAddress();
                    break;
                case 8:
                    ac.deleteActorByName();
                    break;
                case 9:
                    ac.deleteAllActorByMoviesName();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
        
        sc.close();
    
         MovieService ms =new MovieService();
         
         int choice1;
         
         do {
             System.out.println("1. Add Movie");
             System.out.println("2. Find Movie By Id");
             System.out.println("3. Find Movie By Name");
             System.out.println("4. Find All Movies By Director");
             System.out.println("5. Find All Movies By Genre");
             System.out.println("6. Find All Movies By Actor Name");
             System.out.println("7. Update All Movies By BoxofficeCollection");
             System.out.println("8. Delete Movie By Name");
             System.out.println("9. Delete All Movies By Director Name");
             System.out.println("10. Delete All Movies By Actor Name ");
             System.out.println("0. Exit");
             System.out.print("Enter your choice: ");
             choice1 = sc.nextInt();
             
             switch (choice1) {
                 case 1:
                    ms.addMovie();;
                     break;
                 case 2:
                	 ms.findMoviesById();
                     break;
                 case 3:
                	  ms.findMoviesByName();
                     break;
                 case 4:
                	 ms.findAllMoviesByDirector();
                     break;
                 case 5:
                	    ms.findAllMoviesByGenre();
                     break;
                 case 6:
                	 ms.findAllMoviesByActorName();
                     break;
                 case 7:
                	  ms.updateAllMoviesByBoxofficeCollection();
                     break;
                 case 8:
                	 ms.deleteMovieByName();
                     break;
                 case 9:
                	  ms.deleteAllMovieByDirector();
                     break;
                 case 10:
                	 ms.deleteAllMovieByActorName();
                	 break;
                 case 0:
                     System.out.println("Exiting...");
                     break;
                 default:
                     System.out.println("Invalid choice. Please try again.");
                     break;
             }
         } while (choice != 0);
         
         sc.close();
     }
}
       


