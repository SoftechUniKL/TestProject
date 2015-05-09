import java.awt.FlowLayout;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class BudgetPlanGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollpane;
	private BudgetPlanModel budget;

	public BudgetPlanGUI(BudgetPlanModel budget) {
		super("BudgetPlan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());

		this.budget = budget;
		initWindow();
		addBehavior();
		setBounds(10, 10, 800, 800);
		setVisible(true);

	}

	// Initialisieren des Fensters
	protected void initWindow() {
		Object[][] data = new Object[budget.ausgaben.size()][3];

		int i = 0;
		for (Posten p : budget.ausgaben) {
			data[i][0] = new SimpleDateFormat("dd/MM/yyyy").format(p.datum);
			data[i][1] = p.bezeichnung;
			data[i][2] = String.format("%.2f", p.betrag);
			i++;
		}

		table = new JTable(data, new Object[] { "Datum", "Bezeichnung",
				"Betrag" });
		scrollpane = new JScrollPane(table);

		DefaultPieDataset pd = new DefaultPieDataset();
		for (Posten p : budget.ausgaben) {
			pd.setValue(p.bezeichnung, p.betrag);
		}
		JFreeChart pie = ChartFactory.createPieChart("Ausgaben", pd);
		ChartPanel panel = new ChartPanel(pie);

		// Elemente dem Fenster hinzufuegen:
		getContentPane().add(scrollpane);
		getContentPane().add(panel);
		// Berechnet Layout mit geringstem Platzbedarf
		pack();
	}

	// Verhalten hinzufuegen
	public void addBehavior() {
		// TODO Registrieren Sie hier die Ereignisse des Frames!
	}

}