import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SemihAndl extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JLabel lblNewLabel_1;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					SemihAndl frame = new SemihAndl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SemihAndl() {

		String[] comboBoxDizisi = { "---Seçiniz---", "Öğrenci Kredisi", "Yatırımcı Kredisi", "Çiftçi Kredisi" };
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Kredi Türünü Seçiniz:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(97, 98, 136, 22);
		contentPane.add(lblNewLabel);

		JComboBox comboBox = new JComboBox(comboBoxDizisi);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (comboBox.getSelectedIndex()) {
				case 0:
					lblNewLabel_1.setText("Kredi Türü Seçiniz");
					break;
				case 1:
					KrediKA krediKA = new KrediKA(new OgrenciKredi());
					lblNewLabel_1.setText(Float.toString(krediKA.krediYonetici.faizOrani()));
					break;
				case 2:
					KrediKA krediKA2 = new KrediKA(new CiftciKredi());
					lblNewLabel_1.setText(Float.toString(krediKA2.krediYonetici.faizOrani()));
					break;
				case 3:
					KrediKA krediKA3 = new KrediKA(new YatirimciKredi());
					lblNewLabel_1.setText(Float.toString(krediKA3.krediYonetici.faizOrani()));
					break;
				}
			}
		});
		comboBox.setBounds(236, 100, 136, 22);
		contentPane.add(comboBox);

		textField_1 = new JTextField();

		lblNewLabel_1 = new JLabel("Kredi Türü Seçiniz");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(242, 153, 130, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblFaizOran = new JLabel("Faiz oranı:");
		lblFaizOran.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaizOran.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaizOran.setBounds(97, 147, 136, 22);
		contentPane.add(lblFaizOran);

		JButton btnNewButton = new JButton("Hesapla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				float girilenTutar = Float.parseFloat(textField_1.getText());
				if (Float.parseFloat(textField_1.getText()) <= 0) {
					textField.setText("Geçerli Bir Tutar Giriniz");
				} else if (comboBox.getSelectedIndex() == 0) {
					textField.setText("Kredi Türü Seçiniz");
				} else {
					switch (comboBox.getSelectedIndex()) {
					case 0:
						break;
					case 1:
						KrediKA krediKA = new KrediKA(new OgrenciKredi());
						textField.setText(Float.toString(girilenTutar * krediKA.krediYonetici.faizOrani()));
						break;
					case 2:
						KrediKA krediKA2 = new KrediKA(new CiftciKredi());
						textField.setText(Float.toString(girilenTutar * krediKA2.krediYonetici.faizOrani()));
						break;
					case 3:
						KrediKA krediKA3 = new KrediKA(new YatirimciKredi());
						textField.setText(Float.toString(girilenTutar * krediKA3.krediYonetici.faizOrani()));
						break;
					}
				}
				;

			}
		});
		btnNewButton.setBounds(189, 202, 89, 23);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(236, 254, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblGeridenecekTutar = new JLabel("Geri Ödenecek Tutar:");
		lblGeridenecekTutar.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeridenecekTutar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGeridenecekTutar.setBounds(97, 251, 136, 22);
		contentPane.add(lblGeridenecekTutar);

		JLabel lblNewLabel_2 = new JLabel("Çekilecek tutarı giriniz:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(97, 52, 136, 22);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(236, 55, 136, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
