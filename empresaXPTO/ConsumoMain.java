package empresaXPTO;

public class ConsumoMain {
    public static void main(String[] args) {

        int[][] consumo = {
                {800, 700, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800},
                {900, 750, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900},
                {1000, 800, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000},
                {1100, 900, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100},
                {1200, 950, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100, 2200},
                {1300, 1000, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300},
                {1400, 1050, 1500, 1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400},
                {1500, 1100, 1600, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500},
                {1600, 1150, 1700, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500, 2600},
                {1700, 1200, 1800, 1900, 2000, 2100, 2200, 2300, 2400, 2500, 2600, 2700}
        };

        // Imprime o consumo médio de cada mês de cada ano
        for (int i = 0; i < consumo.length; i++) {
            System.out.println("Ano " + (2010 + i) + ":");
            for (int j = 0; j < consumo[i].length; j++) {
                double media = consumo[i][j] / 30.0;
                System.out.printf("Mês %d: %.2f kWh\n", (j+1), media);
            }
            System.out.println();
        }

        int totalConsumo = 0;
        int maxConsumo = Integer.MIN_VALUE;
        int maxMes = 0;
        int maxAno = 0;

        for (int i = 0; i < consumo.length; i++) {
            System.out.println("Consumo médio do ano " + (2010 + i) + ":");
            for (int j = 0; j < consumo[i].length; j++) {
                totalConsumo += consumo[i][j];
                System.out.println("Mês " + (j+1) + ": " + (consumo[i][j]/1000.0) + " kWh");
                if (consumo[i][j] > maxConsumo) {
                    maxConsumo = consumo[i][j];
                    maxMes = j + 1;
                    maxAno = 2010 + i;
                }
            }
            System.out.println("Consumo médio anual: " + (totalConsumo/12000.0) + " kWh");
            totalConsumo = 0;
        }

        System.out.println("Mês/Ano com maior consumo: " + maxMes + "/" + maxAno + " (" + (maxConsumo/1000.0) + " kWh)");
    }
    }

