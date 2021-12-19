package calculadora;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Grafico implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JLabel label = new JLabel();
	JPanel fakePanel;
	ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("calculadora.png"));
	
	int auxiliarSinal = 0;
	
	String valores = "";
	Operadores operadores = new Operadores();
	
	public Grafico() {
		
		frame = new JFrame();
		panel = new JPanel();
		
		frame.setSize(250,300);
		frame.setTitle("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(Color.DARK_GRAY);
		frame.add(panel);
		
		frame.setIconImage(icon.getImage());
		
		label.setFont(new Font("Arial",Font.ITALIC,12));
		
		fakePanel = new JPanel();
		fakePanel.setBackground(Color.WHITE);
		fakePanel.setBounds(10, 10, 160, 41);
		panel.add(fakePanel);
		
		//Repetição para criar todos os botões de 1 a 9
		for(int i = 1; i <= 9; i++) {
			int coluna = 0;
			if(i >= 7)
				coluna = 100;
			else if(i >= 4) {
				coluna = 50;
			}
			buttons(i, coluna);
		}
		buttons();
		
		panel.setLayout(null);
		frame.setVisible(true);
	}
	//butões de 1 a 9
	public void buttons(int quant, int coluna) {
		JButton button = new JButton(Integer.toString(quant));
		button.setFont(new Font("Arial", Font.BOLD,12));
		button.addActionListener(this);
		if(quant >= 7)
			quant = (quant - 7)+1;
		else if(quant >= 4)
			quant = (quant - 4)+1;
		button.setBounds(quant*50-40, 160-coluna, 41, 41);
		panel.add(button);
	}
	//butões de caracteres e botão 0
	public void buttons() {
		JButton buttonIgual = new JButton("=");
		buttonIgual.addActionListener(this);
		buttonIgual.setFont(new Font("Arial", Font.BOLD,12));
		buttonIgual.setBounds(110, 210, 41, 41);
		panel.add(buttonIgual);
		
		JButton buttonVirgu = new JButton(",");
		buttonVirgu.addActionListener(this);
		buttonVirgu.setFont(new Font("Arial", Font.BOLD,12));
		buttonVirgu.setBounds(60, 210, 41, 41);
		panel.add(buttonVirgu);
		
		JButton button0 = new JButton("0");
		button0.addActionListener(this);
		button0.setFont(new Font("Arial", Font.BOLD,12));
		button0.setBounds(10, 210, 41, 41);
		panel.add(button0);
		
		JButton buttonSoma = new JButton("+");
		buttonSoma.setFont(new Font("Arial", Font.BOLD,12));
		buttonSoma.addActionListener(this);
		buttonSoma.setBounds(180, 210, 43, 41);
		panel.add(buttonSoma);
		
		JButton buttonSub = new JButton("-");
		buttonSub.addActionListener(this);
		buttonSub.setFont(new Font("Arial", Font.BOLD,12));
		buttonSub.setBounds(180, 160, 43, 41);
		panel.add(buttonSub);
		
		JButton buttonMulti = new JButton("*");
		buttonMulti.addActionListener(this);
		buttonMulti.setFont(new Font("Arial", Font.BOLD,12));
		buttonMulti.setBounds(180, 110, 43, 41);
		panel.add(buttonMulti);
		
		JButton buttonDivi = new JButton("÷");
		buttonDivi.addActionListener(this);
		buttonDivi.setFont(new Font("Arial", Font.BOLD,12));
		buttonDivi.setBounds(180, 60, 43, 41);
		panel.add(buttonDivi);
		
		JButton buttonPorcent = new JButton("%");
		buttonPorcent.addActionListener(this);
		buttonPorcent.setFont(new Font("Arial", Font.BOLD,12));
		buttonPorcent.setBounds(180, 10, 43, 41);
		panel.add(buttonPorcent);
		
		JButton buttonApaga = new JButton("<");
		buttonApaga.setBackground(Color.WHITE);
		buttonApaga.setFont(new Font("Arial", Font.BOLD,11));
		buttonApaga.addActionListener(this);
		buttonApaga.setBounds(131,10,40,41);
		panel.add(buttonApaga);
	}
	
	
	//metódo do pacote actionperformed para receber a informação do click
	@Override
	public void actionPerformed(ActionEvent e) {
		fakePanel.setOpaque(false);
		if(e.getActionCommand() == "=") {
			valores += " = " + operadores.resultado(valores, auxiliarSinal);
			label.setText("  "+valores);
			valores = "";
			auxiliarSinal = 0;
			return;
		}
		valores += e.getActionCommand();
		if(e.getActionCommand() == "<") 
			valores = "";
		
		if(e.getActionCommand() == "+")
			auxiliarSinal = 1;
		else if(e.getActionCommand() == "-")
			auxiliarSinal = 2;
		else if(e.getActionCommand() == "*")
			auxiliarSinal = 3;
		else if(e.getActionCommand() == "÷")
			auxiliarSinal = 4;
		else if(e.getActionCommand() == "%" && auxiliarSinal == 2)
			auxiliarSinal = 6;
		else if(e.getActionCommand() == "%")
			auxiliarSinal = 5;
		
		label.setText("  " + valores);
		label.setForeground(Color.BLACK);
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(10, 10, 160, 41);
		panel.add(label);
		//Comandos para ajudar no processamento do label
		panel.validate();
		panel.repaint();
	}
	
	
}
