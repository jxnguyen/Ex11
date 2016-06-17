class Ex11 {

	public static void main(String[] args) {
		
	}
}


class Knoten {
    int wert;
    Knoten next;

    Knoten(int i) {
        wert = i;
        this.wert = i; // Ã¤quivalent

        next = null; // Ã¼berflÃ¼ssig
    }
}

class VerketteteListe {
    public static void main(String [] x) {
        Knoten a = new Knoten(5);
        Knoten b = new Knoten(3);
        System.out.println(b.wert);
        System.out.println(b.next);
        System.out.println(b);
        Knoten c = b.next;
        System.out.println(c.wert);
    }

    Knoten eingang;

    public void einfÃ¼ge(int i) {
        Knoten a = new Knoten(i);
        a.next = eingang;
        eingang = a;
    }

    public void durchlaufe(int i) {
        Knoten a = eingang;
        while (a!=null) {
            System.out.println(a.wert);
            a = a.next;
        }
    }
}
