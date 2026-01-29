package IpPackage;

public class IpPackage {
    private int octet1, octet2, octet3, octet4;

    // Le constructeur (privé car on utilise getInstance)
    private IpPackage(int o1, int o2, int o3, int o4) {
        this.octet1 = o1;
        this.octet2 = o2;
        this.octet3 = o3;
        this.octet4 = o4;
    }

    // Service : GetInstance (Vérifie si l'instanciation est possible)
    public static IpPackage getInstance(int o1, int o2, int o3, int o4) {
        if (o1 < 0 || o1 > 255 || o2 < 0 || o2 > 255 || o3 < 0 || o3 > 255 || o4 < 0 || o4 > 255) {
            System.out.println("Valeur impossible \n");
            return null;
        }
        return new IpPackage(o1, o2, o3, o4);
    }

    // Service : getClasse (Retourne la classe d'adresse)
    public char getClasse() {
        if (octet1 <= 127) return 'A';
        if (octet1 <= 191) return 'B';
        if (octet1 <= 223) return 'C';
        return 'D';
    }

    // Service : adresseReseau (Retourne l'adresse réseau)
    public String adresseReseau() {
        char classe = getClasse();
        if (classe == 'A') return octet1 + ".0.0.0";
        if (classe == 'B') return octet1 + "." + octet2 + ".0.0";
        if (classe == 'C') return octet1 + "." + octet2 + "." + octet3 + ".0";
        return "N/A";
    }

    // Services : getOctet1 à getOctet4
    public int getOctet1() { return octet1; }
    public int getOctet2() { return octet2; }
    public int getOctet3() { return octet3; }
    public int getOctet4() { return octet4; }

    // Service : ToString (Affiche l'objet)
    public String ToString() {
        return octet1 + "." + octet2 + "." + octet3 + "." + octet4;
    }
}
