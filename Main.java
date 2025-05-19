import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        ImageIcon[] icon = {
                new ImageIcon("/src/img/encryptions.jpg"),
                new ImageIcon("/src/img/calender.jpeg")
        };
        ImageIcon[] icon1 = {
                new ImageIcon("src/img/guess-the-number-small.jpg"),
                new ImageIcon("src/img/OIP.jpeg")
        };
        ImageIcon[] icon2 = {
                new ImageIcon("src/img/project.jpg"),
                new ImageIcon("src/img/Game.png")
        };

        int x = JOptionPane.showOptionDialog(null, null, null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icon2, icon2[0]);
        while (x != -1) {
            switch (x) {
                case 0: {
                    int o = JOptionPane.showOptionDialog(null, null, "Choose Which Project To Open :", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icon, icon[0]);
                    switch (o) {
                        case 0: {
                            java2();
                            break;
                        }
                        case 1: {
                            java1();
                            break;
                        }
                        case -1: {
                            System.exit(0);
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    int j = JOptionPane.showOptionDialog(null, null, "What Do You Want To Play :", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icon1, icon2[0]);
                    switch (j) {
                        case -1: {
                            System.exit(0);
                            break;
                        }
                        case 0: {
                            guess();
                            break;
                        }
                        case 1: {
                            rps();
                            break;
                        }
                    }
                }
                break;
            }
            x = JOptionPane.showOptionDialog(null, null, null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, icon2, icon2[0]);
        }
    }

    public static void rps() {
        ImageIcon[] image1 = {
                new ImageIcon("src/img/OIP1.jpeg"),
                new ImageIcon("src/img/OIP2.jpeg"),
                new ImageIcon("src/img/OIP3.jpeg"),
                new ImageIcon("src/img/icon.jpeg")
        };
        ImageIcon[] image = {
                new ImageIcon("src/img/R.jpeg"),
                new ImageIcon("src/img/12.jpg"),
                new ImageIcon("src/img/draw.jpg")
        };
        int f = 0;
        while (f == 0) {
            int x = JOptionPane.showOptionDialog(null, "", "choose what you want to play with :", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, image1, null);
            int y = (int) (Math.random() * 3);
            if (x == -1) {
                return;
            }
            if (x == 3) {
                x = (int) (Math.random() * 3);
            }
            ImageIcon[] image2 = {image1[y], image1[x]};
            // 0 rock 1 paper 2 scissor
            if (x == y) {
                JOptionPane.showMessageDialog(null, image2);
                f = JOptionPane.showConfirmDialog(null, null, "Do You Want To Play Again", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, image[2]);
            } else if ((x == 0 && y == 1) || (x == 1 && y == 2) || (x == 2 && y == 0)) {
                JOptionPane.showMessageDialog(null, image2);
                f = JOptionPane.showConfirmDialog(null, null, "Do You Want To Play Again", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, image[0]);
            } else {
                JOptionPane.showMessageDialog(null, image2);
                f = JOptionPane.showConfirmDialog(null, null, "Do You Want To Play Again", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, image[1]);
            }
        }
    }

    public static void java2() {
        String[] h = {"encryption", "decryption"};
        int n = JOptionPane.showOptionDialog(null, "message", "title", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, h, 0);
        if (n == -1) {
            return;
        }
        String s1 = "", s2 = "", s = JOptionPane.showInputDialog("message");
        if (s == null) {
            return;
        }
        for (int j = 0; j < s.length(); j++) {
            String f = "", b = "", a = toBinary(s.charAt(j));
            if (n == 0) {
                s2 = "the encryption of the text";
            } else if (n == 1) {
                s2 = "the decryption of the text";
            }
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == '0') {
                    b += 1;
                } else if (a.charAt(i) == '1') {
                    b += 0;
                }
            }
            for (int i = 0; i < b.length(); i++) {
                if (i < 6) {
                    f += b.charAt(6 + i);
                } else {
                    f += b.charAt(i - 6);
                }
            }
            s1 += (char) Integer.parseInt(f, 2);
        }
        JOptionPane.showMessageDialog(null, s1, s2, JOptionPane.INFORMATION_MESSAGE);
        System.out.println(s1);
    }

    public static String toBinary(int decimal) {
        int[] binary = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int index = 0;
        while (decimal > 0) {
            binary[index++] = decimal % 2;
            decimal /= 2;
        }
        String s = "";
        for (int i = binary.length - 1; i >= 0; i--) {
            s += binary[i];
        }
        return s;
    }

    public static void java1() {
        int leapYears;
        String u = JOptionPane.showInputDialog("Enter The Year");
        if (u == null) {
            return;
        }
        int y = Integer.parseInt(u);
        long totalDays;
        leapYears = (y - 1) / 4;
        if (y != 0) {
            totalDays = leapYears * 366L + ((y - 1) - leapYears) * 365L;
        } else {
            totalDays = 0;
        }
        int day, n = 0;
        for (int j = 1; j <= 12; j++) {
            System.out.println("********************************************");
            if (j == 1) {
                System.out.println("          MONTH:JANUARY");
                n = 31;
            }
            if (j == 2) {
                System.out.println("          MONTH:FEBRUARY");
                if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) {
                    n = 29;
                } else {
                    n = 28;
                }
            }
            if (j == 3) {
                System.out.println("          MONTH:MARCH");
                n = 31;
            }
            if (j == 4) {
                System.out.println("          MONTH:APRIL");
                n = 30;
            }
            if (j == 5) {
                System.out.println("          MONTH:MAY");
                n = 31;
            }
            if (j == 6) {
                System.out.println("          MONTH:JUNE");
                n = 30;
            }
            if (j == 7) {
                System.out.println("          MONTH:JULY");
                n = 31;
            }
            if (j == 8) {
                System.out.println("          MONTH:AUGUST");
                n = 31;
            }
            if (j == 9) {
                System.out.println("          MONTH:SEPTEMBER");
                n = 30;
            }
            if (j == 10) {
                System.out.println("          MONTH:OCTOBER");
                n = 31;
            }
            if (j == 11) {
                System.out.println("          MONTH:NOVEMBER");
                n = 30;
            }
            if (j == 12) {
                System.out.println("          MONTH:DECEMBER");
                n = 31;
            }
            System.out.println("********************************************");
            System.out.println("SUN  MON  TUE  WED  THU  FRI  SAT");
            for (int i = 1; i <= n; i++) {
                day = (int) (totalDays % 7);
                if (i < 10) {
                    System.out.print(" ");
                }
                switch (day) {
                    case 0: {
                        System.out.print(i);
                        totalDays++;
                        break;
                    }
                    case 1: {
                        if (i == 1) {
                            System.out.print("  ");
                        }
                        System.out.print("    " + i);
                        totalDays++;
                        break;
                    }
                    case 2: {
                        if (i == 1) {
                            System.out.print("        ");
                        }
                        System.out.print("   " + i);
                        totalDays++;
                        break;
                    }
                    case 3: {
                        if (i == 1) {
                            System.out.print("             ");
                        }
                        System.out.print("   " + i);
                        totalDays++;
                        break;
                    }
                    case 4: {
                        if (i == 1) {
                            System.out.print("                  ");
                        }
                        System.out.print("   " + i);
                        totalDays++;
                        break;
                    }
                    case 5: {
                        if (i == 1) {
                            System.out.print("                       ");
                        }
                        System.out.print("   " + i);
                        totalDays++;
                        break;
                    }
                    case 6: {
                        if (i == 1) {
                            System.out.print("                            ");
                        }
                        System.out.println("   " + i);
                        totalDays++;
                        break;
                    }
                }
            }
            System.out.println(" ");
        }
    }

    public static void guess() {
        ImageIcon[] image1 = {
                new ImageIcon("src/img/VaryHigh.jpg"),
                new ImageIcon("src/img/high.jpg"),
                new ImageIcon("src/img/low.jpg"),
                new ImageIcon("src/img/VaryLow.jpg")
        };
        ImageIcon image = new ImageIcon("src/img/R (2).png");
        ImageIcon image2;
        int z = 1 + (int) (Math.random() * 100);
        String[] s = {"Try Again", "Show the Answer"};
        System.out.println(z);
        String u = JOptionPane.showInputDialog(null, image, " Pick  A Number Between 1~100", JOptionPane.PLAIN_MESSAGE);
        System.out.println(u);
        if (u == null) {
            return;
        }
        int n = 1, x = Integer.parseInt(u), j;
        while (x != z) {
            if (z < x && x - 10 <= z) {
                image2 = image1[1];
            } else if (x > z) {
                image2 = image1[0];
            } else if (x + 10 >= z) {
                image2 = image1[2];
            } else {
                image2 = image1[3];
            }
            j = JOptionPane.showOptionDialog(null, null, null, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, image2, s, 0);
            if (j == -1) {
                return;
            } else if (j == 1) {
                JOptionPane.showMessageDialog(null, z, "The Answer IS :", JOptionPane.PLAIN_MESSAGE);
                return;
            }
            u = JOptionPane.showInputDialog(null, image, " Pick  A Number Between 1~100", JOptionPane.PLAIN_MESSAGE);
            if (u == null) {
                return;
            }
            x = Integer.parseInt(u);
            n++;
        }
        ImageIcon image3 = new ImageIcon("src/img/ans1.jpeg");
        JOptionPane.showMessageDialog(null, "You Got It in " + n + " attempts", "You Got The Right Answer :", JOptionPane.PLAIN_MESSAGE, image3);
        System.out.println("Correct \n u have " + n + "attempts");
    }
}
