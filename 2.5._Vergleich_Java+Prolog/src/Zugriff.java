import java.util.Scanner;

public class Zugriff {
    public static Mann[] mannARR;
    public static void main(String[] args) {
        mannARR = new Mann[7];
        mannARR[0] = new Mann("lenian");
        mannARR[1] = new Mann("benno");
        mannARR[2] = new Mann("lorenz", "lenian", "helga");
        mannARR[3] = new Mann("bob", "lorenz", "anisa");
        mannARR[4] = new Mann("arnd", "lorenz", "anisa");
        mannARR[5] = new Mann("caspar", "arnd", "julia");
        mannARR[6] = new Mann("markus", "arnd", "julia");

        Scanner scanner = new Scanner(System.in);
        while (true){
            String x;
            String y = "";
            System.out.println("\n?-");
            String eingabe = scanner.next();
            //Finden der benötigten Klasse
            String funktion = eingabe.substring(0, eingabe.indexOf("("));
            if (funktion.equals("mann")){
                x = eingabe.substring(eingabe.indexOf("(") + 1, eingabe.indexOf(")"));
            } else {
                x = eingabe.substring(eingabe.indexOf("(") + 1, eingabe.indexOf(","));
                y = eingabe.substring(eingabe.indexOf(",") + 1, eingabe.indexOf(")"));
            }

            switch (funktion) {
                case "mann":
                    mann(x);
                    break;
                case "vater":
                    vater(x, y);
                    break;
                case "grossmutter":
                    grossmutter(x, y);
                    break;
                case "grossvater":
                    grossvater(x, y);
                    break;
                case "bruder":
                    if (bruder(x, y) != null) {
                        if (x.equals("X") && !y.equals("Y")) {
                            System.out.println("X: " + bruder(x, y));
                        } else if (!x.equals("X") && y.equals("Y")) {
                            System.out.println("Y: " + bruder(x, y));
                        } else {
                            System.out.println(bruder(x, y));
                        }
                    }
                    break;
                case "onkel":
                    onkel(x, y);
                    break;
            }
        }
    }

    public static void mann(String x){
        if (x.equals("X")){
            for (Mann mann : mannARR) {
                System.out.println("X: " + mann.getName()); //In der Liste mannArr befinden sich nur Männer! (Sonst: Definition Geschlecht)
            }
        }
        else {
            for (int i = 0; i < mannARR.length; i++) {
                if (mannARR[i].getName().equals(x)) {
                    System.out.println("true");
                    break;
                } else if (mannARR.length == i+1){
                    System.out.println("false");
                }
            }
        }
    }

    public static void vater(String x, String y){
        if (x.equals("X") && !y.equals("Y")) {
            for (int i = 0; i < mannARR.length; i++) {
                if (mannARR[i].getVater() != null) {
                    if (mannARR[i].getVater().equals(y)) {
                        System.out.println("X: " + mannARR[i].getName());
                        return;
                    }
                } else if (mannARR.length == i + 1) {
                    System.out.println("false");
                }
            }
        }
        else if (!x.equals("X") && y.equals("Y")) {
            for (int i = 0; i < mannARR.length; i++) {
                if (mannARR[i].getName().equals(x)) {
                    System.out.println("Y: " + mannARR[i].getVater());
                    return;
                } else if (mannARR.length == i + 1) {
                    System.out.println("false");
                }
            }
        }
        if (x.equals("X") && y.equals("Y")) {
            for (int i = 0; i < mannARR.length; i++) {
                if (mannARR[i].getName() != null && mannARR[i].getVater() != null) {
                    System.out.println("X: " + mannARR[i].getName() + ", Y: " + mannARR[i].getVater());
                } else if (mannARR.length == i + 1) {
                    System.out.println("false");
                }
            }
        }
        else{
            for (int i = 0; i < mannARR.length; i++) {
                if (mannARR[i].getName().equals(x) && mannARR[i].getVater().equals(y)) {
                    System.out.println("true");
                    return;
                } else if (mannARR.length == i + 1) {
                    System.out.println("false");
                }
            }
        }
    }

    public static void grossvater(String x, String y){
        if (x.equals("X") && !y.equals("Y")){
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getVater().equals(y)) {
                        String z = mann.getName();
                        for (Mann value : mannARR) {
                            if (value.getVater() != null) {
                                if (value.getVater().equals(z)) {
                                    System.out.println("X: " + value.getName());
                                }
                            }
                        }
                    }
                }
            }
        } else if (y.equals("Y") && !x.equals("X")){
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getName().equals(x)) {
                        String z = mann.getVater();
                        for (Mann value : mannARR) {
                            if (value.getVater() != null) {
                                if (value.getName().equals(z)) {
                                    System.out.println("Y: " + value.getVater());
                                }
                            }
                        }
                    }
                }
            }
        } else if (x.equals("X")){ //y==Y bereits geklärt
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    String enkel = mann.getName();
                    String z = mann.getVater();
                    for (Mann value : mannARR) {
                        if (value.getName().equals(z) && value.getVater() != null) {
                            System.out.println("X: " + enkel + ", Y: " + value.getVater());
                        }
                    }
                }
            }
        } else {
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getName().equals(x)) {
                        String z = mann.getVater();
                        for (Mann value : mannARR) {
                            if (value.getVater() != null) {
                                if (value.getName().equals(z) && value.getVater().equals(y)) {
                                    System.out.println("true");
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("false");
    }

    public static void grossmutter(String x, String y){
        if (x.equals("X") && !y.equals("Y")){
            for (Mann mann : mannARR) {
                if (mann.getMutter() != null) {
                    if (mann.getMutter().equals(y)) {
                        String z = mann.getName();
                        for (Mann value : mannARR) {
                            if (value.getVater() != null) {
                                if (value.getVater().equals(z)) {
                                    System.out.println("X: " + value.getName());
                                }
                            }
                        }
                    }
                }
            }
        } else if (y.equals("Y") && !x.equals("X")){
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getName().equals(x)) {
                        String z = mann.getVater();
                        for (Mann value : mannARR) {
                            if (value.getMutter() != null) {
                                if (value.getName().equals(z)) {
                                    System.out.println("Y: " + value.getMutter());
                                }
                            }
                        }
                    }
                }
            }
        } else if (x.equals("X")){ //y==Y bereits geklärt
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    String enkel = mann.getName();
                    String z = mann.getVater();
                    for (Mann value : mannARR) {
                        if (value.getName().equals(z) && value.getMutter() != null) {
                            System.out.println("X: " + enkel + ", Y: " + value.getMutter());
                        }
                    }
                }
            }
        } else {
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getName().equals(x)) {
                        String z = mann.getVater();
                        for (Mann value : mannARR) {
                            if (value.getMutter() != null) {
                                if (value.getName().equals(z) && value.getMutter().equals(y)) {
                                    System.out.println("true");
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("false");
    }

    public static String bruder (String x, String y){
        if (x.equals("X") && !y.equals("Y")){
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getName().equals(y)) {
                        String vater = mann.getVater();
                        for (Mann value : mannARR) {
                            if (value.getVater() != null) {
                                if (value.getVater().equals(vater) && !mann.equals(value)) {
                                    return value.getName();
                                }
                            }
                        }
                    }
                }
            }
        }
        else if (!x.equals("X") && y.equals("Y")){
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getName().equals(x)) {
                        String vater = mann.getVater();
                        for (Mann value : mannARR) {
                            if (value.getVater() != null) {
                                if (value.getVater().equals(vater) && !mann.equals(value)) {
                                    return value.getName();
                                }
                            }
                        }
                    }
                }
            }
        }
        else if (x.equals("X")){ //y==Y bereits geklärt
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    String vater = mann.getVater();
                    for (Mann value : mannARR) {
                        if (value.getVater() != null) {
                            if (value.getVater().equals(vater) && !mann.equals(value)) {
                                System.out.println("X: " + mann.getName() + ", Y: " + value.getName() + "; ");

                            }
                        }
                    }
                }
            }
            return null;
        }
        else {
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getName().equals(x)) {
                        String vater = mann.getVater();
                        for (Mann value : mannARR) {
                            if (value.getVater() != null) {
                                if (value.getVater().equals(vater) && value.getName().equals(y)) {
                                    return "true";
                                }
                            }
                        }
                    }
                }
            }
        }
        return "false";
    }

    public static void onkel (String x, String y){
        if (x.equals("X") && !y.equals("Y")){
            String vater = bruder("X", y);
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getVater().equals(vater)) {
                        System.out.println("X: " + mann.getName());
                    }
                }
            }
        } else if (!x.equals("X") && y.equals("Y")){
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getName().equals(x)) {
                        System.out.println("Y: " + bruder(mann.getVater(), "Y"));
                    }
                }
            }
        } else if (x.equals("X")){ //y==Y bereits geklärt
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    String vater = mann.getVater();
                    for (Mann value : mannARR) {
                        if (value.getVater() != null) {
                            if (value.getVater().equals(mann.getName())) {
                                String neffe = value.getName();
                                for (Mann item : mannARR) {
                                    if (item.getVater() != null) {
                                        if (item.getVater().equals(vater) && !mann.equals(item)) {
                                            System.out.println("X: " + neffe + ", Y: " + item.getName() + "; ");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            for (Mann mann : mannARR) {
                if (mann.getVater() != null) {
                    if (mann.getName().equals(x) && bruder(mann.getVater(), y).equals("true")) {
                        System.out.println("true");
                        return;
                    }
                }
            }
        }
        System.out.println("false");
    }
}