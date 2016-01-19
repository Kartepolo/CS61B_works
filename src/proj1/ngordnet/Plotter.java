package ngordnet;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import com.xeiam.xchart.SwingWrapper;
import com.xeiam.xchart.StyleManager.ChartTheme;
import com.xeiam.xchart.ChartBuilder;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Set;
public class Plotter {
	
	public static void plotTS(TimeSeries<?> ts, String title,
			String xlabel, String ylabel, String legend) {
		Collection<Number> years = ts.years();
		Collection<Number> counts = ts.data();
		Chart chart = QuickChart.getChart(title, ylabel, xlabel, legend, years, counts);
		new SwingWrapper(chart).displayChart();
	}
	
	public static void plotCountHistory(NGramMap ngm,String word,
			int startyear, int endyear) {
		TimeSeries<Double> countHistory = ngm.countHistory(word, startyear, endyear);
		plotTS(countHistory, "Popularity", "years", "count", word);
	}
	public static void plotWeightHistory(NGramMap ngm,String word,
			int startyear, int endyear) {
		TimeSeries<Double> countHistory = ngm.weightHistory(word, startyear, endyear);
		plotTS(countHistory, "Popularity", "years", "weight", word);
	}
public static void plotCategoryWeights(NGramMap ngm, WordNet wn, String categoryLabel,
		int startyear, int endyear) {
	String[] words = wn.hyponyms(categoryLabel);
	TimeSeries<Double> summedWeights = ngm.summedWeightHistory(words, startyear, endyear);
	plotTS(summedWeights, "Popularity", "years", "count", categoryLabel);
}
public static void plotCategoryWeights(NGramMap ngm, WordNet wn, String[] categoryLabels,
		int startyear, int endyear) {
	
	Chart chart = new ChartBuilder().width(800).height(600).xAxisTitle("data").yAxisTitle("years").build();
	for (String c : categoryLabels) {
		String[] words = wn.hyponyms(c);
		TimeSeries<Double> bundle = ngm.summedWeightHistory(words, startyear, endyear);
		chart.addSeries(c, bundle.years(), bundle.data());
	}
	new SwingWrapper(chart).displayChart();
}
public static void plotAllWords(NGramMap ngm, String[] words, int startyear, int endyear) {
	Chart chart = new ChartBuilder().width(800).height(600).xAxisTitle("data").yAxisTitle("years").build();
	for (String w : words) {
		TimeSeries<Double> bundle = ngm.weightHistory(w, startyear, endyear);
		chart.addSeries(w, bundle.years(), bundle.data());
	}
	new SwingWrapper(chart).displayChart();
}
private static Collection<Number> downRange(int max) {
	ArrayList<Number> ranks = new ArrayList<Number>();
	for (int i = max; i > 0; i --) {
		ranks.add(i);
	}
	return ranks;
}
public static void plotZipfsLaw(NGramMap ngm, int year) {
	YearlyRecord yr = ngm.getRecord(year);
	Collection<Number> counts = yr.counts();
	Collection<Number> ranks = downRange(counts.size());
	Chart chart = new ChartBuilder().width(800).height(600).xAxisTitle("rank").yAxisTitle("count").build();
    chart.getStyleManager().setYAxisLogarithmic(true);
    chart.getStyleManager().setXAxisLogarithmic(true);
    chart.addSeries("zipf", ranks, counts);
    new SwingWrapper(chart).displayChart();
}
}
