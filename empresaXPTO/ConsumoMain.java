package empresaXPTO;

public class ConsumoMain {
    public static void main(String[] args) {

        int[][] consumo = {
                {50, 50, 69, 93, 83, 88, 101, 95, 121, 107, 120, 90},
                {95, 44, 1, 101, 104, 115, 115, 140, 104, 98, 96, 79},
                {105, 135, 100, 116, 0, 0, 0, 1, 1, 38, 150, 209},
                {204, 183, 168, 159, 174, 181, 160, 160, 140, 189, 165, 190},
                {232, 222, 242, 236, 235, 233, 177, 188, 200, 201, 240, 235},
                {240, 241, 232, 251, 240, 234, 280, 240, 241, 233, 238, 200},
                {190, 235, 245, 234, 233, 241, 233, 238, 232, 241, 248, 247},
                {249, 248, 245, 253, 251, 249, 250, 239, 240, 244, 246, 245},
                {249, 251, 256, 240, 251, 252, 250, 249, 251, 251, 253, 252},
                {251, 252, 253, 251, 254, 259, 260, 258, 255, 254, 256, 257}
        };

        /**
         *  Imprime o consumo médio de cada mês de cada ano
         * */
        for (int i = 0; i < consumo.length; i++) {
            System.out.println("Ano " + (2010 + i) + ": ");

            for (int j = 0; j < consumo[i].length; j++) {
                double consumoAtual = consumo[i][j];
                System.out.printf("Mês %d: %.2f kWh\n", (j + 1), consumoAtual);
            }
            System.out.println();
        }

        int totalConsumo = 0;
        int maxConsumo = Integer.MIN_VALUE;
        int maxMes = 0;
        int maxAno = 0;

        for (int i = 0; i < consumo.length; i++) {
            System.out.println("Consumo médio do ano " + (2010 + i) + ":");
            double soma = 0;
            for (int j = 0; j < consumo[i].length; j++) {
                totalConsumo += consumo[i][j];
                soma += consumo[i][j];
                double media = soma / 12;
                System.out.printf("Mês " + (j + 1) + ": " + " %.2f kWh\n", (media));
                if (consumo[i][j] > maxConsumo) {
                    maxConsumo = consumo[i][j];
                    maxMes = j + 1;
                    maxAno = 2010 + i;
                }
            }
            System.out.println("Consumo médio anual: " + (totalConsumo / 12) + " kWh");
            totalConsumo = 0;
        }
        System.out.println("Mês/Ano com maior consumo: " + maxMes + "/" + maxAno + " (" + (maxConsumo) + " kWh)");
    }
}
