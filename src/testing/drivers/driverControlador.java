package testing.drivers;

import domini.Assignatura;
import domini.CtrlDominio;

import java.util.Scanner;

import static domini.TipusAula.stoTipusAula;

public class driverControlador {
    private static void menu() {
        System.out.println("Driver Controlador:");
        System.out.println("Opcions:");
        System.out.println("\t1) Crear Pla:");
        System.out.println("\t\tformat: 1 NomPlaEstudis<String> HoraInicial<int> HoraFinal<int>     //Valors entre 0-24 HoraInicial < HoraFinal");

        System.out.println("\t2) Crear Assignatura:");
        System.out.println("\t\tformat: 2 NomAssignatura<String> Fase<String> CapacitatGrup<int> CapacitatSubgrups<int> matriculats<int> TipusAula<TipusAula> numeroSessionsPerGrup<int> duracioSessions<int>");

        System.out.println("\t3) Crear Aula:");
        System.out.println("\t\tformat: 3 NomAula<String> Capacitat<int> TipusAula<TipusAula>");

        System.out.println("\t4) Afegir restriccio de tipus:");
        System.out.println("\t\tformat: 4 1     //Afegir RestriccioFase per tenir en compte els nivells de les assignatures");
        System.out.println("\t\tformat: 4 2     //Afegir RestriccioCorrequisits per tenir en compte correquisits entre Assignatures");
        System.out.println("\t\tformat: 4 3     //Afegir RestriccioTipusAula");
        System.out.println("\t\tformat: 4 4     //Afegir RestriccioCapacitat");
        System.out.println("\t\tformat: 4 5     //Afegir RestriccioGrupDiaHora");
        System.out.println("\t\tformat: 4 6 nomAula<String>     //Afegir RestriccioClasse per bloquejar una Aula en un dia i hora concreta");

        System.out.println("\t5) Generar Horari");
        System.out.println("\t\tformat: 5");

        System.out.println("\t6) Sortir:");
        System.out.println("\t\tformat: 6");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        menu();
        CtrlDominio C = new CtrlDominio();
        int opcio = sc.nextInt();

        while(opcio!=6){
            try {
                switch (opcio) {
                    case 1:
                        String nom = sc.next();
                        int horaIni = sc.nextInt();
                        int horaFi = sc.nextInt();
                        if (horaIni >= horaFi || horaFi > 24 || horaIni < 0 || horaFi<0 ||horaIni > 24)  System.out.println("Valors entre 0-24 i HoraInicial < HoraFinal");
                        else {
                            C.crear_pla(nom, horaIni, horaFi);
                            System.out.println("Pla Esperat: " + nom + " comença a les " + horaIni + " i acaba a les " + horaFi);
                            System.out.println("Pla Obtingut: " + C.getPla().getNom() + " comença a les " + C.getPla().getPeriodeLectiu()[0] + " i acaba a les " + C.getPla().getPeriodeLectiu()[1]);
                        }
                        break;
                    case 2:
                        if (C == null) throw new NullPointerException();
                        C.crear_assignatura(sc.next(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt(),stoTipusAula(sc.next()),sc.nextInt(),sc.nextInt());
                        System.out.println("Assignatura: " + C.getHorari().getSessions().get(3).getNomAssignaturaSessio() + " " + C.getHorari().getSessions().get(3).getNumGrupSessio() + " " + C.getHorari().getSessions().get(3).getNum());
                        break;
                    case 3:
                        if (C == null) throw new NullPointerException();
                        System.out.println("\t\tformat: 5");
                        C.crear_aula(sc.next(),sc.nextInt(),stoTipusAula(sc.next()));
                        System.out.println("Classe: " + C.getHorari().getClasses().get(3).getNomAulaClasse() + " " + C.getHorari().getClasses().get(3).getDiaClasse() + " " + C.getHorari().getClasses().get(3).getHoraClasse());

                        break;
                   /* case 4:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Fase assignatura esperada: " + fase);
                        System.out.println("Fase assignatura obtinguda: " + a.getFase());
                        break;*/
                    case 5:

                        break;/*
                    case 6:
                        nom = sc.next();
                        if (a == null) throw new NullPointerException();
                        a.setNom(nom);
                        if (nom.equals(a.getNom())) System.out.println("Nom assignatura assignat correctament");
                        else System.out.println("Nom assignatura NO assignat correctament");
                        break;
                    case 7:
                        fase = sc.next();
                        if (a == null) throw new NullPointerException();
                        a.setFase(fase);
                        if (fase.equals(a.getFase())) System.out.println("Fase assignatura assignada correctament");
                        else System.out.println("Fase assignatura NO assignada correctament");
                        break;*/
                }

            } catch (NullPointerException n){
                System.out.println("Abans de provar aquesta opcio utilitza la creadora");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Introdueix una opcio amb el seu format:");
                opcio = sc.nextInt();
            }
        }
    }
}