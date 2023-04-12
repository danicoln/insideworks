package rankingPagadores;

import java.util.*;

public class appMain {
    public static void main(String[] args) throws Exception {

        /**
         * Adiciona os pagamentos na lista
         * */
        List<String[]> pagamentos = new ArrayList<>(){{
            add(new String[]{"F", "2022-05-01", "0"});
            add(new String[]{"A", "2022-04-03", "1"});
            add(new String[]{"C", "2022-04-04", "1"});
            add(new String[]{"A", "2022-06-06", "1"});
            add(new String[]{"B", "2022-20-06", "0"});
            add(new String[]{"B", "2022-06-21", "0"});
            add(new String[]{"I", "2022-05-01", "1"});
            add(new String[]{"I", "2022-04-03", "0"});
            add(new String[]{"F", "2022-04-04", "1"});
            add(new String[]{"F", "2022-06-06", "0"});
            add(new String[]{"A", "2022-06-20", "0"});
            add(new String[]{"C", "2022-06-21", "0"});
            add(new String[]{"C", "2022-03-12", "1"});
            add(new String[]{"C", "2022-07-14", "1"});
            add(new String[]{"C", "2022-07-15", "1"});
            add(new String[]{"B", "2022-07-12", "0"});
            add(new String[]{"I", "2022-07-15", "1"});
            add(new String[]{"I", "2022-06-16", "1"});
            add(new String[]{"A", "2022-05-10", "0"});
            add(new String[]{"B", "2022-03-12", "1"});
        }};

        /**
         * Cria um Map de pagamentos por cada empresa e total de pagamentos realizados
         * Através do laço for, itera para cada pagamento da lista de pagamentos e calcula os pagamentos por cada empresa e o total de pagamentos realizados
         * */
        Map<String, Integer> totalPagamentosPorEmpresa = new HashMap<>();
        Map<String, Integer> totalPagamentosRealizadosPorEmpresa = new HashMap<>();

        for (String[] pagamento : pagamentos) {
            String nomeEmpresa = pagamento[0];
            int pagou = Integer.parseInt(pagamento[2]);

            totalPagamentosPorEmpresa.put(nomeEmpresa, totalPagamentosPorEmpresa.getOrDefault(nomeEmpresa, 0) + 1);
            totalPagamentosRealizadosPorEmpresa.put(nomeEmpresa, totalPagamentosRealizadosPorEmpresa.getOrDefault(nomeEmpresa, 0) + pagou);
        }

        /**
         * Cria uma lista das empresas que realizaram pagamento
         * itera no laço e faz o calculo de média de pagamento
         * */

        List<Map.Entry<String, Double>> empresasPagadoras = new ArrayList<>();
        for (Map.Entry<String, Integer> empresa : totalPagamentosPorEmpresa.entrySet()) {
            String nomeEmpresa = empresa.getKey();
            int totalPagamentos = empresa.getValue();
            int totalPagamentosEfetuados = totalPagamentosRealizadosPorEmpresa.get(nomeEmpresa);

            double mediaPagamentosEfetuados = (double) totalPagamentosEfetuados / totalPagamentos;

            empresasPagadoras.add(new AbstractMap.SimpleEntry<>(nomeEmpresa, mediaPagamentosEfetuados));
        }

        empresasPagadoras.sort(Map.Entry.<String, Double>comparingByValue().reversed());

        for (Map.Entry<String, Double> empresa : empresasPagadoras) {
            System.out.printf("Empresa: %s - Média de pagamentos: %.2f \n", empresa.getKey(), empresa.getValue() );


        }
    }
}


