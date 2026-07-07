//Name:Ayni mohamed ibrahim
//ID:c1240061


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    private static Scanner scanner = new Scanner(System.in);
    private static String savedPin = "";          // PIN-ka la kaydiyay
    private static double balance = 500.00;       // Haraaga hadda
    private static List<String> transactionHistory = new ArrayList<>(); // Taariikhda

    public static void main(String[] args) {
        // Soo dhaweyn iyo PIN
        while (true) {
            System.out.print("Fadlan garaac *810#: ");
            String ussd = scanner.nextLine();
            if (ussd.equals("*810#")) break;
        }

        while (true) {
            System.out.print("Fadlan geli pin kaaga (Enter pin): ");
            String pin = scanner.nextLine();
            if (pin.matches("\\d{4}")) {
                savedPin = pin;
                System.out.println("PIN-ka waa laguu oggolaaday. Kusoo dhawaaw Jeeb!");
                break;
            } else {
                System.out.println("PIN-ku waa inuu noqdaa 4 nambar oo kaliya.\n");
            }
        }

        // Menu-ga weyn oo ku wareegsan loop
        while (true) {
            System.out.println("\n=================================");
            System.out.println("            JEEB                ");
            System.out.println("=================================");
            System.out.println("1. Itus Haraaga");
            System.out.println("2. Kaarka hadalka");
            System.out.println("3. Kaarka Internet");
            System.out.println("4. Lacag Dirid");
            System.out.println("5. Bixi Biil");
            System.out.println("6. Warbixin Kooban");
            System.out.println("7. Banks");
            System.out.println("8. TAAJ");
            System.out.println("9. Maareynta");
            System.out.println("0. KaBax");
            System.out.print("\nDooro adeega: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    itusHaraaga();
                    break;
                case "2":
                    kaarkaHadalka();
                    break;
                case "3":
                    kaarkaInternet();
                    break;
                case "4":
                    lacagDirid();
                    break;
                case "5":
                    bixiBiil();
                    break;
                case "6":
                    warbixinKooban();
                    break;
                case "7":
                    banks();
                    break;
                case "8":
                    taaj();
                    break;
                case "9":
                    maareynta();
                    break;
                case "0":
                    kaBax();
                    break;
                default:
                    System.out.println("Kaliya dooro nambarada list ga.");
            }
        }
    }

    // ===================== 1. ITUS HARGA =====================
    public static void itusHaraaga() {
        System.out.println("\n--------------------------------");
        System.out.printf("Haraagaaga hadda waa: $%.2f%n", balance);
        System.out.println("--------------------------------");
    }

    // ===================== 2. KAARKA HADALKA =====================
    public static void kaarkaHadalka() {
        while (true) {
            System.out.println("\n--------------------------------");
            System.out.println("Kaarka hadalka");
            System.out.println("1. Ku Shubo Airtime (isaga)"
                    + "\n2. Ugu Shub Airtime (dad kale)"
                    + "\n3. Data Bundle Subscriptions"
                    + "\n00. Noqo"
                    + "\n0. KaBax");
            System.out.print("\nFadlan dooro: ");

            String airtimeChoice = scanner.nextLine();

            if (airtimeChoice.equals("1") || airtimeChoice.equals("2") || airtimeChoice.equals("3")) {
                double lacagta = 0;
                while (true) {
                    System.out.print("\nFadlan Geli lacagta: $");
                    String input = scanner.nextLine();
                    try {
                        lacagta = Double.parseDouble(input);
                        if (lacagta <= 0) {
                            System.out.println("Lacagtu waa inay ka badnaataa $0.");
                        } else if (lacagta > balance) {
                            System.out.println("Haraagaagu kuma filna. Haraagga hadda: $" + balance);
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Fadlan geli nambar sax ah (Xarfo lama oggola).");
                    }
                }
                // Ka jar haraagga
                balance -= lacagta;
                transactionHistory.add("Ku shubasho airtime: $" + lacagta);
                System.out.println("Habsocodka kaarka hadalka oo u dhigma $" + lacagta + " waa lagu guulaystay.");
                System.out.println("Haraaga cusub: $" + balance);
                break;
            } else if (airtimeChoice.equals("00")) {
                System.out.println("Waxaad ku laabanaysaa menu-gii hore...");
                break;
            } else if (airtimeChoice.equals("0")) {
                kaBax();
            } else {
                System.out.println("Dookh khaldan, fadlan isku day markale.");
            }
        }
    }

    // ===================== 3. KAARKA INTERNET =====================
    public static void kaarkaInternet() {
        while (true) {
            System.out.println("\n--------------------------------");
            System.out.println("Kaarka Internet");
            System.out.println("1. Xirmo Maalinle ah ($2)"
                    + "\n2. Xirmo Toddobaadle ah ($10)"
                    + "\n3. Xirmo Bileed ah ($25)"
                    + "\n00. Noqo"
                    + "\n0. KaBax");
            System.out.print("\nDooro xirmada ad rabto: ");

            String internetChoice = scanner.nextLine();
            double qiimo = 0;
            String xirmo = "";

            if (internetChoice.equals("1")) {
                qiimo = 2.0;
                xirmo = "Maalinle";
            } else if (internetChoice.equals("2")) {
                qiimo = 10.0;
                xirmo = "Toddobaadle";
            } else if (internetChoice.equals("3")) {
                qiimo = 25.0;
                xirmo = "Bileed";
            } else if (internetChoice.equals("00")) {
                System.out.println("Waxaad ku laabanaysaa menu-gii hore...");
                break;
            } else if (internetChoice.equals("0")) {
                kaBax();
            } else {
                System.out.println("Dookh khaldan, fadlan isku day markale.");
                continue;
            }

            if (qiimo > balance) {
                System.out.println("Haraagaagu kuma filna. Haraagga hadda: $" + balance);
                continue;
            }

            balance -= qiimo;
            transactionHistory.add("Xirmo internet ($" + qiimo + ") - " + xirmo);
            System.out.println("\nXirmada internet-ka ee " + xirmo + " waa kuu firfircoon tahay. Mahadsanid!");
            System.out.println("Haraaga cusub: $" + balance);
            break;
        }
    }

    // ===================== 4. LACAG DIRID =====================
    public static void lacagDirid() {
        System.out.println("\n--------------------------------");

        // Hubi PIN ka hor intaadan dirin
        System.out.print("Fadlan geli PIN-kaaga si aad u dirto lacag: ");
        String pinCheck = scanner.nextLine();
        if (!pinCheck.equals(savedPin)) {
            System.out.println("PIN khaldan! Howsha waa la joojiyay.");
            return;
        }

        String mobile1 = "";
        while (true) {
            System.out.print("Fadlan Geli Mobile-ka (lambarka taleefanka): ");
            mobile1 = scanner.nextLine();
            if (mobile1.matches("\\d+")) {
                break;
            } else {
                System.out.println("Khalad! Mobile-ku waa inuu nambar kaliya noqdaa.\n");
            }
        }

        String mobile2 = "";
        while (true) {
            System.out.print("\nFadlan Hubi Mobilka mar kale: ");
            mobile2 = scanner.nextLine();
            if (!mobile2.matches("\\d+")) {
                System.out.println("Khalad! Mobile-ku waa inuu nambar kaliya noqdaa.");
            } else if (!mobile1.equals(mobile2)) {
                System.out.println("Khalad! Laba doorku isku mid ma aha. Fadlan dib u tijaabi.");
            } else {
                break;
            }
        }

        double lacagta = 0;
        while (true) {
            System.out.print("\nFadlan Geli lacagta: $");
            String input = scanner.nextLine();
            try {
                lacagta = Double.parseDouble(input);
                if (lacagta <= 0) {
                    System.out.println("Lacagtu waa inay ka badnaataa $0.");
                } else if (lacagta > balance) {
                    System.out.println("Khalad! Haraagaagu kuma filna (Max: $" + balance + ").");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Khalad! Fadlan geli nambar sax ah (Xarfo lama oggola).");
            }
        }

        System.out.println("\nAre you sure to transfer $" + lacagta + " to (" + mobile2 + "), Charges: $0 ?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        String confirm = scanner.nextLine();

        if (confirm.equals("1")) {
            balance -= lacagta;
            transactionHistory.add("Lacag dirid: $" + lacagta + " -> " + mobile2);
            System.out.println("\nLacagta waa la diray. Mahadsanid!");
            System.out.println("Haraaga cusub: $" + balance);
        } else {
            System.out.println("\nWaad baajisay lacag dirista.");
        }
        System.out.println("--------------------------------");
    }

    // ===================== 5. BIXI BIIL =====================
    public static void bixiBiil() {
        while (true) {
            System.out.println("\n--------------------------------");
            System.out.println("Bixi Biil");
            System.out.println("1. Ku libso (biilka)"
                    + "\n00. Noqo"
                    + "\n0. KaBax");
            System.out.print("\nDooro dookhaaga: ");

            String billChoice = scanner.nextLine();

            if (billChoice.equals("1")) {
                String billId = "";
                while (true) {
                    System.out.print("\nFadlan Geli Aqoonsiga Biilka (Tixgelin): ");
                    billId = scanner.nextLine();
                    if (billId.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("Khalad! Aqoonsiga biilka waa inuu nambar kaliya noqdaa.");
                    }
                }

                double qiimo = 0;
                while (true) {
                    System.out.print("Geli lacagta biilka: $");
                    String input = scanner.nextLine();
                    try {
                        qiimo = Double.parseDouble(input);
                        if (qiimo <= 0) {
                            System.out.println("Lacagtu waa inay ka badnaataa $0.");
                        } else if (qiimo > balance) {
                            System.out.println("Haraagaagu kuma filna. Haraagga: $" + balance);
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Fadlan geli nambar sax ah.");
                    }
                }

                balance -= qiimo;
                transactionHistory.add("Bixi biil: $" + qiimo + " (ID: " + billId + ")");
                System.out.println("Biilka 'Ku libso' ee nambarkiisu yahay (" + billId + ") waa la bixiyay.");
                System.out.println("Haraaga cusub: $" + balance);
                break;
            } else if (billChoice.equals("00")) {
                System.out.println("Waxaad ku laabanaysaa menu-gii hore...");
                break;
            } else if (billChoice.equals("0")) {
                kaBax();
            } else {
                System.out.println("Dookh khaldan, fadlan isku day markale.");
            }
        }
    }

    // ===================== 6. WARBIXIN KOOBAN =====================
    public static void warbixinKooban() {
        while (true) {
            System.out.println("\n===== Warbixin Kooban =====");
            System.out.println("1. Last Action"
                    + "\n2. Wareejintii u dambeysay"
                    + "\n3. libsashadii u dambeysay"
                    + "\n4. Last 3 Actions"
                    + "\n5. Dhammaan Taariikhda"
                    + "\n0. Noqo"
                    + "\n00. Ka Bax");
            System.out.print("Fadlan dooro: ");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                if (transactionHistory.isEmpty()) {
                    System.out.println("Weli wax howl ah ma jiraan.");
                } else {
                    System.out.println("\nLast Action: " + transactionHistory.get(transactionHistory.size() - 1));
                }
            } else if (choice.equals("2")) {
                // Wareejinta u dambeysay - waxaan raadinaynaa "Lacag dirid"
                String lastTransfer = transactionHistory.stream()
                        .filter(s -> s.startsWith("Lacag dirid"))
                        .reduce((a, b) -> b)
                        .orElse("Weli ma jirto wareejin.");
                System.out.println("\n[Wareejintii u dambeysay]: " + lastTransfer);
            } else if (choice.equals("3")) {
                String lastPurchase = transactionHistory.stream()
                        .filter(s -> s.startsWith("Xirmo") || s.startsWith("Ku shubasho"))
                        .reduce((a, b) -> b)
                        .orElse("Weli ma jirto libsasho.");
                System.out.println("\n[Libsashadii u dambeysay]: " + lastPurchase);
            } else if (choice.equals("4")) {
                System.out.println("\nLast 3 Actions:");
                int size = transactionHistory.size();
                if (size == 0) {
                    System.out.println("Weli wax howl ah ma jiraan.");
                } else {
                    int start = Math.max(0, size - 3);
                    for (int i = start; i < size; i++) {
                        System.out.println("- " + transactionHistory.get(i));
                    }
                }
            } else if (choice.equals("5")) {
                System.out.println("\nDhammaan Taariikhda:");
                if (transactionHistory.isEmpty()) {
                    System.out.println("Weli wax howl ah ma jiraan.");
                } else {
                    for (String t : transactionHistory) {
                        System.out.println("- " + t);
                    }
                }
            } else if (choice.equals("0")) {
                System.out.println("Waxaad ku laabanaysaa menu-gii hore...");
                break;
            } else if (choice.equals("00")) {
                kaBax();
            } else {
                System.out.println("Dookh khaldan, fadlan isku day markale.");
            }
        }
    }

    // ===================== 7. BANKS =====================
    public static void banks() {
        System.out.println("\n--------------------------------");
        System.out.println("1. Salaam Somali Bank");
        System.out.println("2. Premier Bank");
        System.out.print("Dooro Bangiga: ");
        String bankChoice = scanner.nextLine();
        if (bankChoice.equals("1") || bankChoice.equals("2")) {
            System.out.println("Isku xirka bangiga waa diyaar.");
        } else {
            System.out.println("Dookh khaldan.");
        }
        System.out.println("--------------------------------");
    }

    // ===================== 8. TAAJ =====================
    public static void taaj() {
        while (true) {
            System.out.println("\n--------------------------------");
            System.out.println("TAAJ");
            System.out.println("1. Dibadda (xawaalad)"
                    + "\n2. Ogoow Khidmada"
                    + "\n00. Noqo"
                    + "\n0. KaBax");
            System.out.print("\nFadlan dooro: ");

            String taajChoice = scanner.nextLine();

            if (taajChoice.equals("1")) {
                // Hubi PIN
                System.out.print("Fadlan geli PIN-kaaga si aad u dirto xawaalad: ");
                String pinCheck = scanner.nextLine();
                if (!pinCheck.equals(savedPin)) {
                    System.out.println("PIN khaldan! Howsha waa la joojiyay.");
                    break;
                }

                System.out.print("\nGeli Magaca Qaataha Dibadda: ");
                String magac = scanner.nextLine();

                double lacagta = 0;
                while (true) {
                    System.out.print("Geli Lacagta ($): ");
                    String input = scanner.nextLine();
                    try {
                        lacagta = Double.parseDouble(input);
                        if (lacagta <= 0) {
                            System.out.println("Lacagtu waa inay ka badnaataa $0.");
                        } else if (lacagta > balance) {
                            System.out.println("Haraagaagu kuma filna. Haraagga: $" + balance);
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Khalad! Fadlan geli nambar sax ah.");
                    }
                }

                balance -= lacagta;
                transactionHistory.add("TAAJ Dibadda: $" + lacagta + " -> " + magac);
                System.out.println("Xawaaladda TAAJ ee Dibadda oo ah $" + lacagta + " waa la hambeeyay.");
                System.out.println("Haraaga cusub: $" + balance);
                break;
            } else if (taajChoice.equals("2")) {
                System.out.println("\nKhidmada TAAJ waa $0.50 halkii $100 kasta.");
                break;
            } else if (taajChoice.equals("00")) {
                System.out.println("Waxaad ku laabanaysaa menu-gii hore...");
                break;
            } else if (taajChoice.equals("0")) {
                kaBax();
            } else {
                System.out.println("Dookh khaldan, fadlan isku day markale.");
            }
        }
    }

    // ===================== 9. MAAREYNTA =====================
    public static void maareynta() {
        while (true) {
            System.out.println("\n--------------------------------");
            System.out.println("Maareynta");
            System.out.println("1. Beddel lambarka sirta ah (PIN)"
                    + "\n2. Beddel Luqadda"
                    + "\n3. Wargelin Mobile Lumay"
                    + "\n4. Lacag Xirasho (xiro akoonka)"
                    + "\n5. U celi lacag qaldantay"
                    + "\n00. Noqo"
                    + "\n0. KaBax");
            System.out.print("\nFadlan dooro: ");

            String manageChoice = scanner.nextLine();

            if (manageChoice.equals("1")) {
                System.out.print("\nGeli PIN-kaaga hadda: ");
                String oldPin = scanner.nextLine();
                if (!oldPin.equals(savedPin)) {
                    System.out.println("PIN khaldan! Howsha waa la joojiyay.");
                    continue;
                }
                while (true) {
                    System.out.print("Geli PIN-kaaga cusub (4 nambar): ");
                    String newPin = scanner.nextLine();
                    if (newPin.matches("\\d{4}")) {
                        savedPin = newPin;
                        System.out.println("PIN-kaaga si guul leh ayaa loo beddelay.");
                        break;
                    } else {
                        System.out.println("PIN-ku waa inuu ahaadaa 4 nambar oo kaliya.");
                    }
                }
                break;
            } else if (manageChoice.equals("2")) {
                System.out.println("\n1. Somali");
                System.out.println("2. English");
                System.out.print("Dooro luqadda: ");
                String lang = scanner.nextLine();
                if (lang.equals("1")) {
                    System.out.println("Luqadda Somali waa la dooray.");
                } else if (lang.equals("2")) {
                    System.out.println("English language selected.");
                } else {
                    System.out.println("Dookh khaldan.");
                }
                break;
            } else if (manageChoice.equals("3")) {
                String phone = "";
                while (true) {
                    System.out.print("\nGeli mobile-ka lumay: ");
                    phone = scanner.nextLine();
                    if (phone.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("Khalad! Fadlan geli nambar taleefon oo sax ah.");
                    }
                }
                System.out.println("Wargelinta mobile-ka lumay ee (" + phone + ") waa la diiwangeliyay.");
                break;
            } else if (manageChoice.equals("4")) {
                System.out.println("\nAkoonkaaga si ku-meel-gaar ah ayaa loo xiray.");
                // Halkan waxaad ku dari kartaa logic dheeri ah, haddii aad rabto.
                break;
            } else if (manageChoice.equals("5")) {
                String txnId = "";
                while (true) {
                    System.out.print("\nGeli ID-ga fariinta (TxnID): ");
                    txnId = scanner.nextLine();
                    if (txnId.matches("\\d+")) {
                        break;
                    } else {
                        System.out.println("Khalad! TxnID-gu waa inuu nambar kaliya noqdaa.");
                    }
                }
                System.out.println("Codsigaaga celinta lacagta qaldantay ee TxnID (" + txnId + ") waa la gudbiyay.");
                break;
            } else if (manageChoice.equals("00")) {
                System.out.println("Waxaad ku laabanaysaa menu-gii hore...");
                break;
            } else if (manageChoice.equals("0")) {
                kaBax();
            } else {
                System.out.println("Dookh khaldan, fadlan isku day markale.");
            }
        }
    }

    // ===================== 0. KABAX =====================
    public static void kaBax() {
        System.out.println("Thank you, Goodbye!");
        System.exit(0);
    }
}