package lp2.lab05;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Classe para explorar o uso de objetos da classe {@link GregorianCalendar}.
 *  
 * @author Juiz LP2 - juiz.lp2@gmail.com
 * @author André Luiz Guimarães de Souza Leite
 * @author Marcus Antonio Rocha Tenorio
 */
public class TabajaraCalendarSpeculator {
        
        private static final int YEAR_LOWER_BOUND = 1970;
        private static final int YEAR_UPPER_BOUND = 2100;
        private static final String[] SEMANA = {"domingo", "segunda", "terça", "quarta", "quinta", "sexta", "sabado"};
        private static final int NUMBER_OF_OPTIONS = 9;// change me to add more options
        private static Scanner input;
        private static GregorianCalendar calendario;

        /**
         * Entry point.
         * @param args No arguments are used in this program.
         */
        public static void main(String[] args) {

                input = new Scanner(System.in);
                calendario = new GregorianCalendar();
                
                printHeader();

                int option;
                do {
                        printMenu();
                        option = readIntegerOption("> ", 1, NUMBER_OF_OPTIONS);

                        switch (option) {
                        case 1:
                                countDayInMonth(readWeekDay(), readMonth());
                                break;
                        case 2:
                                getWeekDay(readDay(), readMonth(), readYear());
                                break;
                        case 3:
                                isLeapYear(readYear());
                                break;
                        case 4:
                                printMonthDaysOrdered(readMonth());
                                break;
                        case 5:
                                printHowManyDaysLeftToDate(readDay(), readMonth(), readYear());
                                break;
                        case 6:
                                getDaysLeftInYear();
                                break;
                        case 7:
                        		daysBetweenDates();
                                break;
                        case 8:
                        		funcionalidadeExtra(readYear(), readMonth());
                        //FIXME remember to change it if you want to add more than one option!
                        default:
                                // There's no default behaviour in this case.
                                break;
                        }
                } while (option != NUMBER_OF_OPTIONS);
                
                System.out.println("Obrigado!");
        }

        /**
         * Shows program header.
         */
        private static void printHeader() {
                System.out.println("Bemvindo ao Tabajara Calendar Speculator!\n");
        }

        /**
         * Show menu options.
         */
        private static void printMenu() {
                StringBuilder sb = new StringBuilder();
                sb.append("\nEscolha uma das opcoes: \n");
                sb.append("1 - Quantos dias no mes?\n");
                sb.append("2 - Qual o dia da semana?\n");
                sb.append("3 - Eh um ano bissexto?\n");
                sb.append("4 - Imprime mes.\n");
                sb.append("5 - Quantos dias faltam para a data...?\n");
                sb.append("6 - Quantos dias faltam para acabar o ano?\n");
                sb.append("7 - Funcao Extra!!!!!! .\n");
                sb.append("8 - Funcionalidade Avancada.\n");
                sb.append("9 - Sair.\n");
                System.out.println(sb.toString());
        }

        /**
         * Prompts for and reads an integer option x such that lowerLimit &le; x &le; upperLimit.
         * @param message The prompt message (Use a \n if you want to break a line).
         * @param lowerLimit The lower bound option.
         * @param upperLimit The upper bound option.
         * @return A valid option.
         */
        private static int readIntegerOption(String message, int lowerLimit, int upperLimit) {
                while(true){
                        try{
                                System.out.print(message);
                                Integer number = 0;
                                do {
                                        number = Integer.valueOf(input.nextLine());
                                }while(number < lowerLimit || number > upperLimit);
                                return number;
                        }catch (NumberFormatException nfe) {
                                // Just to avoid crashing in the user's face.
                        }
                }
        }

        /**
         * Prompts to enter a valid day and returns it.
         * @return A valid day.
         */
        private static int readDay() {
                return readIntegerOption("Insira o dia [1-31]: ", 1, 31);
        }

        /**
         * Prompts to enter a valid year and returns it.
         * @return A valid year.
         */
        private static int readYear() {
                return readIntegerOption(String.format("Insira o ano [%d-%d]: ", YEAR_LOWER_BOUND, YEAR_UPPER_BOUND), YEAR_LOWER_BOUND, YEAR_UPPER_BOUND);
        }

        /**
         * Prompts to enter a valid month and returns it.
         * @return A valid month.
         */
        private static int readMonth() {
                return readIntegerOption("Insira o mes [1 = janeiro; 2 = fevereiro; ...; 12 = dezembro]: ", 1, 12);
        }

        /**
         * Prompts to enter a valid week day and returns it.
         * @return A valid week day.
         */
        private static int readWeekDay() {
                return readIntegerOption("Insira o dia da semana [1 = domingo; 2 = segunda-feira; ...; 7 = sabado]: ", 1, 7);
        }

        /**
         * Questao 1-a
         * @param weekDay
         * @param month
         */
        private static void countDayInMonth(int weekDay, int month) {
            calendario.set(Calendar.MONTH, month - 1);
            calendario.set(Calendar.DAY_OF_WEEK, weekDay);
            int vezes = calendario.getActualMaximum(Calendar.DAY_OF_WEEK_IN_MONTH);
            System.out.println("Repete " + vezes + " vezes");
        }

        /**
         * Questao 1-b
         * @param day
         * @param month
         * @param year
         */
        private static void getWeekDay(int day, int month, int year) {
                // TODO Gimme a better name!!!!
           calendario.set(Calendar.DAY_OF_MONTH, day);
           calendario.set(Calendar.MONTH, month - 1);
           calendario.set(Calendar.YEAR, year);
           System.out.println("Dia " + TabajaraCalendarSpeculator.SEMANA[calendario.get(Calendar.DAY_OF_WEEK) - 1]);
                
        }

        /**
         * Questao 1-c
         * @param year
         */
        private static void isLeapYear(int year) {
            // Ja existe essa funcao na classe do gregorian calendar.. pq sobreescrever?
            System.out.println(calendario.isLeapYear(year) ? "É bissexto" : "Não é bissexto");
                
        }

        /**
         * Questao 1-d
         * @param month
         */
        private static void printMonthDaysOrdered(int month) {
            calendario.set(Calendar.MONTH, month - 1);
            
            calendario.set(Calendar.DAY_OF_MONTH, 1);
            for(int day = 1; day <= calendario.getMaximum(Calendar.DAY_OF_MONTH); day++) {
                calendario.set(Calendar.DAY_OF_MONTH, day);
                System.out.print(day + " - " + SEMANA[calendario.get(Calendar.DAY_OF_WEEK) - 1] + ", ");
            }
        }

        /**
         * Questao 1-e
         * @param day
         * @param month
         * @param year
         */
        private static void printHowManyDaysLeftToDate(int day, int month, int year) {
            Calendar future = new GregorianCalendar(year, month - 1, day);
            calendario = new GregorianCalendar();
            System.out.println(future.get(Calendar.DAY_OF_YEAR) - calendario.get(Calendar.DAY_OF_YEAR));
        }

        /**
         * Questao 1-f
         */
        private static void getDaysLeftInYear() {
            calendario = new GregorianCalendar();
            Calendar apocalipse = new GregorianCalendar(Calendar.YEAR, Calendar.DECEMBER, 31);
            System.out.println(apocalipse.get(Calendar.DAY_OF_YEAR) - calendario.get(Calendar.DAY_OF_YEAR) + 1);
       }

        /**
         * Questao extra
         */
        private static void daysBetweenDates() {
        	System.out.println("Primeira data\n");
        	Calendar d1 = new GregorianCalendar(readYear(), readMonth(), readDay());
        	System.out.println("Segunda data\n");
        	Calendar d2 = new GregorianCalendar(readYear(), readMonth(), readDay());
        	System.out.println("Diferenca de dias entre as duas datas : " + (d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR)));
        }
        
        private static void funcionalidadeExtra(int year, int month) {
            boolean firstDay = true;
            calendario.set(Calendar.MONTH, month - 1);
            calendario.set(Calendar.YEAR, year);
            System.out.print("D     S     T     Q     Q     S     S\n");
            boolean firstDayOfWeek = (calendario.get(Calendar.DAY_OF_WEEK) == 7);
        	for(int day = 1; day <= calendario.getMaximum(Calendar.DAY_OF_MONTH); day++) {
        	    calendario.set(Calendar.DAY_OF_MONTH, day);
        	    if(firstDay) {
        	        firstDay = false;
        		for(int espaco = 0; espaco <= calendario.get(Calendar.DAY_OF_WEEK); espaco++)
        		    System.out.print("    ");
        	    }
        		
        	    else if(!firstDayOfWeek)
        	        System.out.print("    ");
        	    else {
        	        System.out.print("");
        		firstDayOfWeek = false;
        	    }
        		
        	System.out.print(day < 10 ? "0" + day : day);
                if(calendario.get(Calendar.DAY_OF_WEEK) == 7) {
                    firstDayOfWeek = true;
                    System.out.print("\n");
                }
            }
        }
}