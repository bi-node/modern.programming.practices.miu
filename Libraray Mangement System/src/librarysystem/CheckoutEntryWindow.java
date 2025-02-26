package librarysystem;

import business.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CheckoutEntryWindow extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LocalDate checkoutDate;
	JTextField txtCheckOutDate, txtdueDate, txtBookTitle;
	JButton btnAddEntry, btnBack, btnCheckEntry;
	CheckoutRecordWindow crw;
	ControllerInterface ci = new SystemController();
	LibraryMember lmember;
	HashMap<String, LibraryMember> memberMap;
	HashMap<String, Book> bookMap;
	Book book;

	DefaultTableModel recordTableModel;
	JTable recordtable;

	public CheckoutEntryWindow(CheckoutRecordWindow crw) {
		// TODO Auto-generated constructor stub

		memberMap = ci.getAllMembers();
		bookMap = ci.getAllBooks();
		this.crw = crw;
		book = bookMap.get(crw.getISBN());
		setBounds(0, 0, 660, 600);
		setTitle("Check Out Entry");
		setLayout(null);
		setVisible(true);
		setBackground(Color.gray);
		Util.centerFrameOnDesktop(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// listing out the entry records of that user

		// Two panels
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 660, 600);
		p1.setLayout(null);
		add(p1);

		// Left hand side labeling
		JLabel lblcheckoutDate = new JLabel("Check Out Date");
		lblcheckoutDate.setBounds(40, 40, 100, 30);
		p1.add(lblcheckoutDate);

		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(40, 80, 100, 30);
		p1.add(lblDueDate);

		JLabel lblBookTitle = new JLabel("Book Title");
		lblBookTitle.setBounds(40, 120, 200, 30);
		p1.add(lblBookTitle);

		// left side text field
		txtCheckOutDate = new JTextField();
		txtCheckOutDate.setBounds(160, 40, 120, 25);
		txtCheckOutDate.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		txtCheckOutDate.setText(LocalDate.now().toString());
		p1.add(txtCheckOutDate);

		txtdueDate = new JTextField();
		txtdueDate.setBounds(160, 80, 120, 25);
		txtdueDate.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		p1.add(txtdueDate);
		txtdueDate.setText(LocalDate.now().plusDays(7).toString());

		txtBookTitle = new JTextField();
		txtBookTitle.setBounds(160, 120, 300, 25);
		txtBookTitle.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		p1.add(txtBookTitle);
		txtBookTitle.setText(book.getTitle());

		// Buttons

		btnBack = Util.newbuttonStyle(new JButton("Back"));
		btnBack.setBounds(40, 160, 100, 40);
		p1.add(btnBack);
		btnBack.addActionListener(this);

		btnCheckEntry = Util.newbuttonStyle(new JButton("Check Entries"));
		btnCheckEntry.setBounds(220, 160, 150, 40);
		p1.add(btnCheckEntry);
		btnCheckEntry.addActionListener(this);

		btnAddEntry = Util.newbuttonStyle(new JButton("Add Entry"));
		btnAddEntry.setBounds(480, 160, 100, 40);
		p1.add(btnAddEntry);
		btnAddEntry.addActionListener(this);

		// records table
		recordTableModel = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

			// Override the isCellEditable method to make all cells uneditable
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		recordTableModel.addColumn("ISBN No.");
		recordTableModel.addColumn("Book Title");
		recordTableModel.addColumn("Check Out Date");
		recordTableModel.addColumn("Due Date");

		recordtable = new JTable(recordTableModel);
		recordtable.setBounds(40, 220, 520, 325);
		recordtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // Adjust column width automatically
		recordtable.getTableHeader().setReorderingAllowed(false); // Disable column reordering
		JScrollPane scrollPane = new JScrollPane(recordtable);
		scrollPane.setBounds(40, 220, 520, 325);

		p1.add(scrollPane);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		String checkoutDate = txtCheckOutDate.getText();
		String dueDate = txtdueDate.getText();

		LibraryMember member = memberMap.get(crw.getMemId());
		CheckOutEntry[] checkoutrecords = member.getCheckOutEntries();
		CheckOutEntry coe = new CheckOutEntry(book, checkoutDate, dueDate);
		

		if (ae.getSource() == btnCheckEntry) {
			listOutRecords(checkoutrecords);
		}

		if (ae.getSource() == btnAddEntry) {
			// check out the book
			if (book.isAvailable()) {
				member.addCheckOutRecord(coe);
				ci.updateLibraryMember(member);
				JOptionPane.showMessageDialog(null, "Record Entry Added Successfully");
				showAddedRecords(coe);
				book.removeCopy();
				ci.updateBook(book);
				//added at last
				btnAddEntry.setEnabled(false);
			}
			else {
				btnAddEntry.setEnabled(false);
			}

		}
		if (ae.getSource() == btnBack) {
			setVisible(false);
			dispose();
		}

	}// end of action performed

	public void listOutRecords(CheckOutEntry[] checkoutrecords) {
		recordTableModel.setRowCount(0);

		for (CheckOutEntry cc : checkoutrecords) {
			String[] rowData = { cc.getBook().getIsbn(), cc.getBook().getTitle(), cc.getCheckOutDate(),
					cc.getDueDate() };
			recordTableModel.addRow(rowData);
		}
	}// end of list out records

	public void showAddedRecords(CheckOutEntry cc) {

		String[] rowData = { cc.getBook().getIsbn(), cc.getBook().getTitle(), cc.getCheckOutDate(), cc.getDueDate() };
		recordTableModel.addRow(rowData);

	}// end

}
