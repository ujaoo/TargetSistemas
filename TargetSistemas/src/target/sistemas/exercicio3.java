package target.sistemas;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class exercicio3 {

	public static void main(String[] args) {

		List<Double> faturamento = new ArrayList<>();

		JSONParser parser = new JSONParser();

		try {
			FileReader reader = new FileReader("JSON/dados.json");

			JSONArray dados = (JSONArray) parser.parse(reader);

			for (Object obj : dados) {
				JSONObject diaFaturamento = (JSONObject) obj;
				double valor = (double) diaFaturamento.get("valor");

				if (valor > 0) {
					faturamento.add(valor);
				}
			}

			reader.close();

			double menorValor = calcularMenorValor(faturamento);
			double maiorValor = calcularMaiorValor(faturamento);
			double mediaMensal = calcularMedia(faturamento);
			int diasAcimaDaMedia = contarDiasAcimaDaMedia(faturamento, mediaMensal);

			System.out.println("Menor valor de faturamento: " + menorValor);
			System.out.println("Maior valor de faturamento: " + maiorValor);
			System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static double calcularMenorValor(List<Double> faturamento) {
		double menor = Double.MAX_VALUE;
		for (double valor : faturamento) {
			if (valor < menor) {
				menor = valor;
			}
		}
		return menor;
	}

	private static double calcularMaiorValor(List<Double> faturamento) {
		double maior = Double.MIN_VALUE;
		for (double valor : faturamento) {
			if (valor > maior) {
				maior = valor;
			}
		}
		return maior;
	}

	private static double calcularMedia(List<Double> faturamento) {
		double soma = 0;
		for (double valor : faturamento) {
			soma += valor;
		}
		return soma / faturamento.size();
	}

	private static int contarDiasAcimaDaMedia(List<Double> faturamento, double media) {
		int dias = 0;
		for (double valor : faturamento) {
			if (valor > media) {
				dias++;
			}
		}
		return dias;
	}
}
