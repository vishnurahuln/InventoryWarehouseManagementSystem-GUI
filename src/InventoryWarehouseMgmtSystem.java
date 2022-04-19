import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.time.LocalDateTime;

import javax.swing.event.*;    
import java.awt.Font;
import javax.swing.table.*;

public class InventoryWarehouseMgmtSystem extends JFrame implements ActionListener { 
	// Components of the Form
    JMenuBar MainMenu;
    JMenu Search,Display,Operate,Help;
    JMenuItem SearchByProducer,SearchByProductName,SearchByPrice,DisplayInventory,DisplayByManufacturer,DisplayByType,DisplayByPrice,DisplayByAvailability,DisplayByDiscount,AddProduct,DeleteProduct,UpdateProduct, RollbackProduct,CommitProduct,Exit;
    JFrame frame;
	private Container c;
	private JLabel addtitle;
    private JLabel addid; 
	private JTextField addtid; 
    private JLabel addname;
    private JTextField addtname;
    private JLabel addproducer;
    private JTextField addtproducer;
    private JLabel addtype;
    private JTextField addttype;
    private JLabel addlocation;
    private JTextField addtlocation;
    private JLabel addprice;
    private JTextField addtprice;
    private JLabel addlistingprice;
    private JTextField addtlistingprice;
    private JLabel adddiscount;
    private JTextField addtdiscount;
    private JLabel addavailability;
    private JTextField addtavailability;
    private JLabel adddate;
    private JTextField addtdate;
    private JLabel addexpdate;
    private JTextField addtexpdate;
    private JButton addsub; 
	private JTextArea addtout; 
	private JLabel addres; 
	private JTextArea addresadd; 
    private JLabel updatetitle; 
	private JLabel upid; 
	private JTextField uptid; 
    private JLabel upcat; 
	private JComboBox uptcat;  
	private JLabel upvalue; 
	private JTextField uptvalue;      
	private JButton upsub; 
	private JTextArea uptout; 
	private JLabel upres; 
	private JTextArea upresadd; 
    private String Category[] = { "ProductID","Product Name", "Producer", "Product Type Code", "Location Code", "Retail Price", "Listing Price", "Discount(%)", "Stock Quantity", "Date Purchased", "Expiration Date"};
    private JLabel deletetitle; 
	private JLabel pid; 
	private JTextField tpid;   
	private JButton delsub; 
	private JTextArea deltout; 
	private JLabel delres; 
	private JTextArea delresadd; 
    private JLabel rollbacktitle;
    private JLabel rollbackid;
    private JTextField rollbacktid;
    private JButton rollbacksub;
    private JTextArea rollbacktout;
    private JLabel rollbackres;
    private JTextArea rollbackresadd;
    private JButton yesRoll;
    private JButton noRoll;
    private JTextField jtf;
    private JLabel searchLbl;
    private TableModel model;
    private JTable table;
    private TableRowSorter sorter;
    private JScrollPane jsp;
    JLabel lab;
    IWMSOperations imso = new IWMSOperations();

	// default constructor to load the form and its components
	public InventoryWarehouseMgmtSystem() 
	{ 
		
		imso.loadEntries();
        //Initialize the frame and its components
        setTitle("Inventory Warehouse Management System GUI");
		setBounds(100, 90, 1200, 750); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(true); 
		c = getContentPane(); 
		c.setLayout(null); 
		c.setBackground(Color.LIGHT_GRAY);
		
        // Initialize the Main Menu and its components
        SearchByProducer=new JMenuItem("Search By Producer");   
        SearchByProductName=new JMenuItem("Search By Product Name"); 
        SearchByPrice=new JMenuItem("Search By Price");  
        DisplayInventory=new JMenuItem("Show Entire inventory");    
        DisplayByManufacturer=new JMenuItem("Show Inventory By Producer");    
        DisplayByType=new JMenuItem("Show Inventory By Type");    
        DisplayByPrice=new JMenuItem("Show Inventory By Price");    
        DisplayByAvailability=new JMenuItem("Show Inventory By Availability");    
        DisplayByDiscount=new JMenuItem("Show Current Discount Items"); 
        AddProduct=new JMenuItem("Add Record/Product");   
        UpdateProduct=new JMenuItem("Update Record");    
        DeleteProduct=new JMenuItem("Remove Record"); 
        RollbackProduct=new JMenuItem("Rollback Record");

        //  Initialize the Search Menu and its components
        MainMenu=new JMenuBar();
        Display=new JMenu("Display Inventory");      
        Search=new JMenu("Search Grocery Item");    
        Operate=new JMenu("Add/Delete/Update/Rollback");

        // Add the menu items to the menu 
        Search.add(SearchByProducer);
        Search.add(SearchByProductName);
        Search.add(SearchByPrice);
        Display.add(DisplayInventory);
        Display.add(DisplayByManufacturer);
        Display.add(DisplayByType);
        Display.add(DisplayByPrice);
        Display.add(DisplayByAvailability);
        Operate.add(AddProduct);
        Operate.add(UpdateProduct);
        Operate.add(DeleteProduct);
        Operate.add(RollbackProduct); 
        MainMenu.add(Search);
        MainMenu.add(Display);
        MainMenu.add(Operate);
        
        //Home Page Title and Logo
        lab=new JLabel();
        ImageIcon icon=new ImageIcon("./src/InventoryManagement_Hero@3x.png");
        lab.setIcon(icon);
        lab.setBounds(75,75,1000,600);
        add(lab);
        addtitle = new JLabel("Welcome to Grocery Store Inventory Warehouse Management System"); 
        addtitle.setFont(new Font("Arial", Font.BOLD, 20)); 
        addtitle.setForeground(Color.black);
        addtitle.setSize(800, 20); 
        addtitle.setLocation(250, 20); 
        c.add(addtitle);     

        // Add Product Button and its components
        c.add(MainMenu);     
        setJMenuBar(MainMenu); 

        //Event Triggers for the Main Menu
        SearchByProducer.addActionListener(this);       
        SearchByProductName.addActionListener(this); 
        SearchByPrice.addActionListener(this); 
        DisplayInventory.addActionListener(this);  
        DisplayByManufacturer.addActionListener(this);    
        DisplayByType.addActionListener(this);    
        DisplayByPrice.addActionListener(this);    
        DisplayByAvailability.addActionListener(this);  
        AddProduct.addActionListener(this);       
        UpdateProduct.addActionListener(this);       
        DeleteProduct.addActionListener(this);
        RollbackProduct.addActionListener(this);
		setVisible(true); 
	} 

    // Main Driver Code for the GUI 
	public static void main(String[] args) throws Exception 
	{ 
		InventoryWarehouseMgmtSystem IWMS = new InventoryWarehouseMgmtSystem(); 
	} 

    public void actionPerformed(ActionEvent e) 
	{ 
        //Add a Product to the Inventory
        if(e.getSource()==AddProduct){
            getContentPane().removeAll();
            getContentPane().repaint();
            setBounds(100, 90, 1200, 750); 
            setDefaultCloseOperation(EXIT_ON_CLOSE); 
            setResizable(false); 
            c = getContentPane(); 
            c.setLayout(null); 
            
            //Adding titles and labels for the Add Product Form
            addtitle = new JLabel("Add Product Form"); 
            addid = new JLabel("Product ID"); 
            addname = new JLabel("Product Name");
            addprice = new JLabel("Price");
            addlistingprice = new JLabel("Listing Price");
            adddiscount = new JLabel("Discount");
            addavailability = new JLabel("Stock");
            addsub = new JButton("Add"); 
            addlocation = new JLabel("Location");
            addtype = new JLabel("Product Type"); 
            addproducer = new JLabel("Producer");
            
            // adding form properties and components to the form
            addtitle.setFont(new Font("Arial", Font.PLAIN, 30)); 
            addtitle.setSize(300, 30); 
            addtitle.setLocation(300, 30); 
            c.add(addtitle); 
            addid.setFont(new Font("Arial", Font.PLAIN, 20)); 
            addid.setSize(150, 20); 
            addid.setLocation(100, 100); 
            c.add(addid); 
            addtid = new JTextField(); 
            addtid.setFont(new Font("Arial", Font.PLAIN, 15)); 
            addtid.setSize(180, 20); 
            addtid.setLocation(235, 100); 
            c.add(addtid); 
            addname.setFont(new Font("Arial", Font.PLAIN, 20)); 
            addname.setSize(150, 20); 
            addname.setLocation(100, 150); 
            c.add(addname); 
            addtname = new JTextField(); 
            addtname.setFont(new Font("Arial", Font.PLAIN, 15)); 
            addtname.setSize(180, 20); 
            addtname.setLocation(235, 150); 
            c.add(addtname);
            addproducer.setFont(new Font("Arial", Font.PLAIN, 20)); 
            addproducer.setSize(150, 20); 
            addproducer.setLocation(100, 175); 
            c.add(addproducer); 
            addtproducer = new JTextField(); 
            addtproducer.setFont(new Font("Arial", Font.PLAIN, 15)); 
            addtproducer.setSize(180, 20); 
            addtproducer.setLocation(235, 175); 
            c.add(addtproducer);
            addtype.setFont(new Font("Arial", Font.PLAIN, 20)); 
            addtype.setSize(150, 20); 
            addtype.setLocation(100, 125); 
            c.add(addtype); 
            addttype = new JTextField(); 
            addttype.setFont(new Font("Arial", Font.PLAIN, 15)); 
            addttype.setSize(180, 20); 
            addttype.setLocation(235, 125); 
            c.add(addttype);
            addlocation.setFont(new Font("Arial", Font.PLAIN, 20));
            addlocation.setSize(150, 20);
            addlocation.setLocation(100, 225);
            c.add(addlocation);
            addtlocation = new JTextField();
            addtlocation.setFont(new Font("Arial", Font.PLAIN, 15));
            addtlocation.setSize(180, 20);
            addtlocation.setLocation(235, 225);
            c.add(addtlocation);
            addprice.setFont(new Font("Arial", Font.PLAIN, 20));
            addprice.setSize(150, 20);
            addprice.setLocation(100, 250);
            c.add(addprice);
            addtprice = new JTextField();
            addtprice.setFont(new Font("Arial", Font.PLAIN, 15));
            addtprice.setSize(180, 20);
            addtprice.setLocation(235, 250);
            c.add(addtprice);
            addlistingprice.setFont(new Font("Arial", Font.PLAIN, 20));
            addlistingprice.setSize(150, 20);
            addlistingprice.setLocation(100, 275);
            c.add(addlistingprice);
            addtlistingprice = new JTextField();
            addtlistingprice.setFont(new Font("Arial", Font.PLAIN, 15));
            addtlistingprice.setSize(180, 20);
            addtlistingprice.setLocation(235, 275);
            c.add(addtlistingprice);
            adddiscount.setFont(new Font("Arial", Font.PLAIN, 20));
            adddiscount.setSize(150, 20);
            adddiscount.setLocation(100, 300);
            c.add(adddiscount);
            addtdiscount = new JTextField();
            addtdiscount.setFont(new Font("Arial", Font.PLAIN, 15));
            addtdiscount.setSize(180, 20);
            addtdiscount.setLocation(235, 300);
            c.add(addtdiscount);
            addavailability.setFont(new Font("Arial", Font.PLAIN, 20));
            addavailability.setSize(150, 20);
            addavailability.setLocation(100, 325);
            c.add(addavailability);
            addtavailability = new JTextField();
            addtavailability.setFont(new Font("Arial", Font.PLAIN, 15));
            addtavailability.setSize(180, 20);
            addtavailability.setLocation(235, 325);
            c.add(addtavailability);
            addsub.setFont(new Font("Arial", Font.PLAIN, 15)); 
            addsub.setSize(100, 20); 
            addsub.setLocation(150, 375);


            addsub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    addres.setText("Added Product Information for ProductID("+ addtid.getText() + ") Successfully!!");
                    //Strings Parsed To Integers for the Add Product Form 
                    int lc = Integer.parseInt(addtlocation.getText());
        			double amsrp = Double.parseDouble(addtprice.getText());
        			double acp = Double.parseDouble(addtlistingprice.getText());
        			double adp= Double.parseDouble(addtdiscount.getText());
        			int asq = Integer.parseInt(addtavailability.getText());
                    imso.productID.add(addtid.getText());
                    imso.itemName.add(addtname.getText());
                    imso.producer.add(addtproducer.getText());
                    imso.itemCategory.add(addttype.getText());
                    imso.locationCode.add(lc);
                    imso.productPrice.add(amsrp);
                    imso.listingPrice.add(acp);
                    imso.discount.add(adp);
                    imso.itemQuantity.add(asq);
                    imso.datePurchased.add(LocalDateTime.now());
		            imso.dateExpired.add(LocalDateTime.now().plusMonths(1));
            }});
            c.add(addsub); 
            addres = new JLabel(""); 
            addres.setFont(new Font("Arial", Font.PLAIN, 20)); 
            addres.setSize(750, 25); 
            addres.setLocation(100, 400); 
            c.add(addres); 
            setVisible(true); 
        }


        //Update Product Form
        if(e.getSource()==UpdateProduct){
            getContentPane().removeAll();
            getContentPane().repaint();
            setBounds(100, 90, 1200, 750); 
            setDefaultCloseOperation(EXIT_ON_CLOSE); 
            setResizable(false); 
            c = getContentPane(); 
            c.setLayout(null); 

            updatetitle = new JLabel("Update Product Info"); 
            upid = new JLabel("Poduct ID"); 
            upcat = new JLabel("Category"); 
            upvalue = new JLabel("Changed Value");
            upsub = new JButton("Update"); 


            updatetitle.setFont(new Font("Arial", Font.PLAIN, 30)); 
            updatetitle.setSize(300, 30); 
            updatetitle.setLocation(300, 30); 
            c.add(updatetitle); 
            upid.setFont(new Font("Arial", Font.PLAIN, 20)); 
            upid.setSize(150, 20); 
            upid.setLocation(100, 100); 
            c.add(upid); 
            uptid = new JTextField(); 
            uptid.setFont(new Font("Arial", Font.PLAIN, 15)); 
            uptid.setSize(180, 20); 
            uptid.setLocation(250, 100); 
            c.add(uptid); 
            upcat.setFont(new Font("Arial", Font.PLAIN, 20)); 
            upcat.setSize(150, 20); 
            upcat.setLocation(100, 135); 
            c.add(upcat); 
            uptcat = new JComboBox(Category); 
            uptcat.setFont(new Font("Arial", Font.PLAIN, 15)); 
            uptcat.setSize(180, 20); 
            uptcat.setLocation(250, 135); 
            c.add(uptcat);
            upvalue.setFont(new Font("Arial", Font.PLAIN, 20)); 
            upvalue.setSize(150, 20); 
            upvalue.setLocation(100, 175); 
            c.add(upvalue); 
            uptvalue = new JTextField(); 
            uptvalue.setFont(new Font("Arial", Font.PLAIN, 15)); 
            uptvalue.setSize(180, 20); 
            uptvalue.setLocation(250, 175); 
            c.add(uptvalue);
            upsub.setFont(new Font("Arial", Font.PLAIN, 15)); 
            upsub.setSize(100, 20); 
            upsub.setLocation(150, 250); 


            upsub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int uptIndex =  imso.productID.indexOf((uptid.getText()));

                    if(uptIndex<0){
                        upres.setText("Product ID not found");
                    }else{
                        upres.setText("Product "+ uptid.getText() +" Updated Sucessfully");
                        String fieldCode = (String)uptcat.getSelectedItem();
                    //Switch Case to Auto-Select Field to be Updated
                        switch(fieldCode){
                            case "Producer":
                                    imso.producer.set(uptIndex, uptvalue.getText());
                                    break;
                            case "Product Name": 
                                    imso.itemName.set(uptIndex, uptvalue.getText());
                                    break;
                            case "Location Code":
                                    int LCint = Integer.parseInt(uptvalue.getText());
                                    imso.locationCode.set(uptIndex, LCint);
                                    break;
                            case "Product Price": 
                                    double PP = Double.parseDouble(uptvalue.getText());
                                    imso.productPrice.set(uptIndex,PP);
                                    break;
                            case "Listing Price": 
                                    double lp = Double.parseDouble(uptvalue.getText());
                                    imso.listingPrice.set(uptIndex,lp);
                                    break;
                            case "Discount (%)":
                                    double disc = Double.parseDouble(uptvalue.getText());
                                    imso.discount.set(uptIndex,disc); 
                                    break;
                            case "Stock Quantity": 
                                    int usq = Integer.parseInt(uptvalue.getText());
                                    imso.itemQuantity.set(uptIndex,usq); 
                                    break;
                        }

                    }

            }});
            c.add(upsub); 

            upres = new JLabel(""); 
            upres.setFont(new Font("Arial", Font.PLAIN, 20)); 
            upres.setSize(500, 25); 
            upres.setLocation(100, 300); 
            c.add(upres); 
            setVisible(true); 
        }
        
//Delete Product Form
        if(e.getSource()==DeleteProduct){
            getContentPane().removeAll();
            getContentPane().repaint();
            setBounds(100, 90, 1200, 750); 
            setDefaultCloseOperation(EXIT_ON_CLOSE); 
            setResizable(false); 
            c = getContentPane(); 
            c.setLayout(null); 
            // adding labels and text fields 
            deletetitle = new JLabel("Delete Product Form"); 
            pid = new JLabel("Product ID"); 
            delsub = new JButton("Delete"); 
            // adding product id text field 
            deletetitle.setFont(new Font("Arial", Font.PLAIN, 30)); 
            deletetitle.setSize(300, 30); 
            deletetitle.setLocation(300, 30); 
            c.add(deletetitle); 
            pid.setFont(new Font("Arial", Font.PLAIN, 20)); 
            pid.setSize(100, 20); 
            pid.setLocation(100, 100); 
            c.add(pid); 
            tpid = new JTextField(); 
            tpid.setFont(new Font("Arial", Font.PLAIN, 15)); 
            tpid.setSize(190, 20); 
            tpid.setLocation(200, 100); 
            c.add(tpid); 
            delsub.setFont(new Font("Arial", Font.PLAIN, 15)); 
            delsub.setSize(100, 20); 
            delsub.setLocation(150, 150); 
            delsub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { 
                    String delId = tpid.getText();
                    int delIndex = imso.productID.indexOf(delId);

                    if(delIndex>=0){
                    	imso.productIDDel.add(imso.productID.get(delIndex));        // moving deleted product id to a deleted list for future use
                        imso.itemNameDel.add(imso.itemName.get(delIndex));
                        imso.producerDel.add(imso.producer.get(delIndex));
                        imso.itemCategoryDel.add(imso.itemCategory.get(delIndex));
                        imso.locationCodeDel.add(imso.locationCode.get(delIndex));
                        imso.productPriceDel.add(imso.productPrice.get(delIndex));
                        imso.listingPriceDel.add(imso.listingPrice.get(delIndex));
                        imso.discountDel.add(imso.discount.get(delIndex));
                        imso.itemQuantityDel.add(imso.itemQuantity.get(delIndex));
                        imso.datePurchasedDel.add(imso.datePurchased.get(delIndex));
                        imso.dateExpiredDel.add(imso.dateExpired.get(delIndex));

                        imso.productID.remove(delIndex);						  // Deleting record details for given productID from the Array lists
                        imso.itemName.remove(delIndex);
                        imso.producer.remove(delIndex);
                        imso.itemCategory.remove(delIndex);
                        imso.locationCode.remove(delIndex);
                        imso.productPrice.remove(delIndex);
                        imso.listingPrice.remove(delIndex);
                        imso.discount.remove(delIndex);
                        imso.itemQuantity.remove(delIndex);
                        imso.datePurchased.remove(delIndex);
                        imso.dateExpired.remove(delIndex);
                        delres.setText("Product "+ tpid.getText() +" Deleted Sucessfully");
                    }
                    else{
                        delres.setText("Product ID not found");
                    }
            }});
            c.add(delsub); 


            delres = new JLabel(""); 
            delres.setFont(new Font("Arial", Font.PLAIN, 20)); 
            delres.setSize(500, 25); 
            delres.setLocation(100, 200); 
            c.add(delres); 

        }   

        //Delete Product Form
        if(e.getSource()==DeleteProduct){
            getContentPane().removeAll();
            getContentPane().repaint();
            setBounds(100, 90, 1200, 750); 
            setDefaultCloseOperation(EXIT_ON_CLOSE); 
            setResizable(false); 
            c = getContentPane(); 
            c.setLayout(null); 
            // adding labels and text fields 
            deletetitle = new JLabel("Delete Product Form"); 
            pid = new JLabel("Product ID"); 
            delsub = new JButton("Delete"); 
            // adding product id text field 
            deletetitle.setFont(new Font("Arial", Font.PLAIN, 30)); 
            deletetitle.setSize(300, 30); 
            deletetitle.setLocation(300, 30); 
            c.add(deletetitle); 
            pid.setFont(new Font("Arial", Font.PLAIN, 20)); 
            pid.setSize(100, 20); 
            pid.setLocation(100, 100); 
            c.add(pid); 
            tpid = new JTextField(); 
            tpid.setFont(new Font("Arial", Font.PLAIN, 15)); 
            tpid.setSize(190, 20); 
            tpid.setLocation(200, 100); 
            c.add(tpid); 
            delsub.setFont(new Font("Arial", Font.PLAIN, 15)); 
            delsub.setSize(100, 20); 
            delsub.setLocation(150, 150); 
            delsub.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { 
                    String delId = tpid.getText();
                    int delIndex = imso.productID.indexOf(delId);

                    if(delIndex>=0){
                    	imso.productIDDel.add(imso.productID.get(delIndex));        // moving deleted product id to a deleted list for future use
                        imso.itemNameDel.add(imso.itemName.get(delIndex));
                        imso.producerDel.add(imso.producer.get(delIndex));
                        imso.itemCategoryDel.add(imso.itemCategory.get(delIndex));
                        imso.locationCodeDel.add(imso.locationCode.get(delIndex));
                        imso.productPriceDel.add(imso.productPrice.get(delIndex));
                        imso.listingPriceDel.add(imso.listingPrice.get(delIndex));
                        imso.discountDel.add(imso.discount.get(delIndex));
                        imso.itemQuantityDel.add(imso.itemQuantity.get(delIndex));
                        imso.datePurchasedDel.add(imso.datePurchased.get(delIndex));
                        imso.dateExpiredDel.add(imso.dateExpired.get(delIndex));

                        imso.productID.remove(delIndex);						  // Deleting record details for given productID from the Array lists
                        imso.itemName.remove(delIndex);
                        imso.producer.remove(delIndex);
                        imso.itemCategory.remove(delIndex);
                        imso.locationCode.remove(delIndex);
                        imso.productPrice.remove(delIndex);
                        imso.listingPrice.remove(delIndex);
                        imso.discount.remove(delIndex);
                        imso.itemQuantity.remove(delIndex);
                        imso.datePurchased.remove(delIndex);
                        imso.dateExpired.remove(delIndex);
                        delres.setText("Product "+ tpid.getText() +" Deleted Sucessfully");
                    }
                    else{
                        delres.setText("Product ID not found");
                    }
            }});
            c.add(delsub); 


            delres = new JLabel(""); 
            delres.setFont(new Font("Arial", Font.PLAIN, 20)); 
            delres.setSize(500, 25); 
            delres.setLocation(100, 200); 
            c.add(delres); 

        }

        //Search by Product Name Form
        if(e.getSource()==SearchByProductName){
            getContentPane().removeAll();
            getContentPane().repaint();
            jtf = new JTextField(15);
            searchLbl = new JLabel("Search by Product Name");
            jtf.setSize(500, 20);
            jtf.setLocation(200, 20);
            searchLbl.setSize(500, 20);
            searchLbl.setLocation(20, 20);
            String Labels[] = { "Product ID","Product Name", "Producer", "Price", "Discount"};
            String[][] ItemsList = new String[imso.productID.size()][5]; 
            for(int i=0;i<imso.productID.size();i++){
                ItemsList[i][0] = imso.productID.get(i);
                ItemsList[i][1] = imso.itemName.get(i);
                ItemsList[i][2] = imso.producer.get(i);
                ItemsList[i][3] = Double.toString(imso.productPrice.get(i));
                ItemsList[i][4] = Double.toString(imso.discount.get(i));
            }
            model = new DefaultTableModel(ItemsList, Labels);
            sorter = new TableRowSorter<>(model);
            table = new JTable(model);
            table.setRowSorter(sorter);
            table.getColumnModel().getColumn(0).setPreferredWidth(60);
            table.getColumnModel().getColumn(1).setPreferredWidth(150);
            table.getColumnModel().getColumn(2).setPreferredWidth(250);
            jsp = new JScrollPane(table);
            jsp.setSize(750, 550);
            jsp.setLocation(200,60);
            add(searchLbl);
            add(jtf);
            add(jsp);
            jtf.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    search(jtf.getText());
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    search(jtf.getText());
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    search(jtf.getText());
                }
                public void search(String str) {
                    if (str.length() == 0) {
                    sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + str, 1));
                    
                    }
                }
            });
            setVisible(true);
        }
        
        

        //Rollback Product Form
        if(e.getSource()==RollbackProduct){
            getContentPane().removeAll();
            getContentPane().repaint();
            setBounds(100, 90, 1200, 750); 
            setDefaultCloseOperation(EXIT_ON_CLOSE); 
            setResizable(false); 
            c = getContentPane(); 
            c.setLayout(null); 
            rollbacktitle = new JLabel("Roll Product Form"); 
            rollbackid = new JLabel("Do you want to rollback?");
            noRoll = new JButton("No"); 
            yesRoll = new JButton("Yes"); 

            rollbacktitle.setFont(new Font("Arial", Font.PLAIN, 30)); 
            rollbacktitle.setSize(300, 30); 
            rollbacktitle.setLocation(300, 30); 
            c.add(rollbacktitle); 
            rollbackid.setFont(new Font("Arial", Font.PLAIN, 20)); 
            rollbackid.setSize(300, 20); 
            rollbackid.setLocation(100, 100); 
            c.add(rollbackid); 
            yesRoll.setFont(new Font("Arial", Font.PLAIN, 15)); 
            yesRoll.setSize(100, 20); 
            yesRoll.setLocation(150, 140);
            noRoll.setFont(new Font("Arial", Font.PLAIN, 15)); 
            noRoll.setSize(100, 20); 
            noRoll.setLocation(300, 140);


            yesRoll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { 
                    if(imso.productIDDel.size() == 0)
                        {
                            rollbackres.setText("No item to rollback!");
                            return;
                        }
                    imso.productID.add(imso.productIDDel.get(imso.productIDDel.size()-1));
                    imso.itemName.add(imso.itemNameDel.get(imso.itemNameDel.size()-1));
                    imso.producer.add(imso.producerDel.get(imso.producerDel.size()-1));
                    imso.itemCategory.add(imso.itemCategoryDel.get(imso.itemCategoryDel.size()-1));
                    imso.locationCode.add(imso.locationCodeDel.get(imso.locationCodeDel.size()-1));
                    imso.productPrice.add(imso.productPriceDel.get(imso.productPriceDel.size()-1));
                    imso.listingPrice.add(imso.listingPriceDel.get(imso.listingPriceDel.size()-1));
                    imso.discount.add(imso.discountDel.get(imso.discountDel.size()-1));
                    imso.itemQuantity.add(imso.itemQuantityDel.get(imso.itemQuantityDel.size()-1));
                    imso.datePurchased.add(imso.datePurchasedDel.get(imso.datePurchasedDel.size()-1));
                    imso.dateExpired.add(imso.dateExpiredDel.get(imso.dateExpiredDel.size()-1));
                    imso.productIDDel.remove(imso.productIDDel.size()-1);
                    imso.itemNameDel.remove(imso.itemNameDel.size()-1);
                    imso.producerDel.remove(imso.producerDel.size()-1);
                    imso.itemCategoryDel.remove(imso.itemCategoryDel.size()-1);
                    imso.locationCodeDel.remove(imso.locationCodeDel.size()-1);
                    imso.productPriceDel.remove(imso.productPriceDel.size()-1);
                    imso.listingPriceDel.remove(imso.listingPriceDel.size()-1);
                    imso.discountDel.remove(imso.discountDel.size()-1);
                    imso.itemQuantityDel.remove(imso.itemQuantityDel.size()-1);
                    imso.datePurchasedDel.remove(imso.datePurchasedDel.size()-1);
                    imso.dateExpiredDel.remove(imso.dateExpiredDel.size()-1);
                    rollbackres.setText("Rollback complete!\n"+ "Rollbacked Product ID: " + imso.productID.get(imso.productID.size()-1) + "\n");
		        }
            });


            noRoll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) { 
                    rollbackres.setText("Rollback Cancelled");
		        }
            });
            c.add(yesRoll); 
            c.add(noRoll);
            rollbackres = new JLabel(""); 
            rollbackres.setFont(new Font("Arial", Font.PLAIN, 20)); 
            rollbackres.setSize(500, 25); 
            rollbackres.setLocation(100, 200); 
            c.add(rollbackres); 
            setVisible(true); 
        }
        
        //Display By Producer  Form
        if(e.getSource()==DisplayByManufacturer){
            getContentPane().removeAll();
            getContentPane().repaint();
            String[][] ItemsList = new String[imso.productID.size()][3]; 
            for(int i=0;i<imso.productID.size();i++){
                ItemsList[i][0] = imso.productID.get(i);
                ItemsList[i][1] = imso.itemName.get(i);
                ItemsList[i][2] = imso.producer.get(i);
            }
            String Labels[] = { "Product ID","Product Name", "Producer"};
            model = new DefaultTableModel(ItemsList, Labels);
            table = new JTable(model);
            table.setRowSorter(sorter);
            updatetitle = new JLabel("Display Complete Warehouse Inventory By Producer");
            updatetitle.setFont(new Font("Arial", Font.PLAIN, 20)); 
            updatetitle.setSize(500, 20); 
            updatetitle.setLocation(300, 20); 
            c.add(updatetitle); 
            jsp = new JScrollPane(table);
            jsp.setSize(750, 550);
            jsp.setLocation(250,60);
            add(jsp);
            setVisible(true);
        } 
        
        //Display Complete Inventory Form
        if(e.getSource()==DisplayInventory){
            getContentPane().removeAll();
            getContentPane().repaint();
            int size = imso.productID.size();
            String[][] ItemsList = new String[size][11]; 
            for(int i=0;i<size;i++){
                ItemsList[i][0] = imso.productID.get(i).toString();
                ItemsList[i][1] = imso.itemName.get(i).toString();
                ItemsList[i][2] = imso.producer.get(i).toString();
                ItemsList[i][3] = imso.itemCategory.get(i).toString();
                ItemsList[i][4] = imso.locationCode.get(i).toString();
                ItemsList[i][5] = imso.productPrice.get(i).toString();
                ItemsList[i][6] = imso.listingPrice.get(i).toString();
                ItemsList[i][7] = imso.discount.get(i).toString();
                ItemsList[i][8] = imso.itemQuantity.get(i).toString();
                ItemsList[i][9] = imso.datePurchased.get(i).toString();
                ItemsList[i][10] = imso.dateExpired.get(i).toString();
            }
            String Labels[] = { "ProductID","Product Name", "Producer", "Product Type Code", "Location Code", "Retail Price", "Listing Price", "Discount(%)", "Stock Quantity", "Date Purchased", "Expiration Date"};
            model = new DefaultTableModel(ItemsList, Labels);
            table = new JTable(model);
            table.setSize(1100, 650); 
            table.setLocation(20, 20);
            table.setRowSorter(sorter);
            table.setPreferredScrollableViewportSize(table.getPreferredSize());
            table.setFillsViewportHeight(true);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(200);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setPreferredWidth(80);
            table.getColumnModel().getColumn(6).setPreferredWidth(100);
            table.getColumnModel().getColumn(7).setPreferredWidth(100);
            table.getColumnModel().getColumn(8).setPreferredWidth(100);
            table.getColumnModel().getColumn(9).setPreferredWidth(225);
            table.getColumnModel().getColumn(10).setPreferredWidth(225);
            updatetitle = new JLabel("Display Complete Warehouse Inventory");
            updatetitle.setFont(new Font("Arial", Font.PLAIN, 20)); 
            updatetitle.setSize(500, 20); 
            updatetitle.setLocation(300, 20); 
            c.add(updatetitle); 
            jsp = new JScrollPane(table);
            jsp.setSize(1125, 600);
            jsp.setLocation(40,60);
            add(jsp);
            setVisible(true);
        }
        
        
        
        //Display By Type Form
        if(e.getSource()==DisplayByType){
            getContentPane().removeAll();
            getContentPane().repaint();
            String[][] ItemsList = new String[imso.productID.size()][3]; 
            for(int i=0;i<imso.productID.size();i++){
                ItemsList[i][0] = imso.productID.get(i);
                ItemsList[i][1] = imso.itemName.get(i);
                ItemsList[i][2] = imso.itemCategory.get(i);
            }
            String Labels[] = { "Product ID","Product Name","Product Category"};
            updatetitle = new JLabel("Display Complete Warehouse Inventory By Type");

            model = new DefaultTableModel(ItemsList, Labels);
            table = new JTable(model);
            table.setRowSorter(sorter);
            updatetitle.setFont(new Font("Arial", Font.PLAIN, 20)); 
            updatetitle.setSize(500, 20); 
            updatetitle.setLocation(300, 20); 
            c.add(updatetitle); 
            jsp = new JScrollPane(table);
            jsp.setSize(750, 550);
            jsp.setLocation(250,60);
            add(jsp);
            setVisible(true);
        } 
        //Display By Price Form
        if(e.getSource()==DisplayByPrice){
            getContentPane().removeAll();
            getContentPane().repaint();
            String[][] ItemsList = new String[imso.productID.size()][3]; 
            for(int i=0;i<imso.productID.size();i++){
                ItemsList[i][0] = imso.productID.get(i);
                ItemsList[i][1] = imso.itemName.get(i);
                ItemsList[i][2] = Double.toString(imso.productPrice.get(i));
            }
            String Labels[] = { "Product ID","Product Name","Retail Price"};
            updatetitle = new JLabel("Display Complete Warehouse Inventory By Price");

            model = new DefaultTableModel(ItemsList, Labels);
            table = new JTable(model);
            table.setRowSorter(sorter);
            updatetitle.setFont(new Font("Arial", Font.PLAIN, 20)); 
            updatetitle.setSize(500, 20); 
            updatetitle.setLocation(300, 20); 
            c.add(updatetitle); 
            jsp = new JScrollPane(table);
            jsp.setSize(750, 550);
            jsp.setLocation(250,60);
            add(jsp);
            setVisible(true);
        } 
        //Display By Availability Form
        if(e.getSource()==DisplayByAvailability){
            getContentPane().removeAll();
            getContentPane().repaint();
            String[][] ItemsList = new String[imso.productID.size()][3]; 
            for(int i=0;i<imso.productID.size();i++){
                ItemsList[i][0] = imso.productID.get(i);
                ItemsList[i][1] = imso.itemName.get(i);
                ItemsList[i][2] = Integer.toString(imso.itemQuantity.get(i));
            }
            String Labels[] = { "Product ID", "Product Name", "Stock Quantity"};
            updatetitle = new JLabel("Display Complete Warehouse Inventory By Availability");

            model = new DefaultTableModel(ItemsList, Labels);
            table = new JTable(model);
            table.setRowSorter(sorter);
            updatetitle.setFont(new Font("Arial", Font.PLAIN, 20)); 
            updatetitle.setSize(500, 20); 
            updatetitle.setLocation(300, 20); 
            c.add(updatetitle); 
            jsp = new JScrollPane(table);
            jsp.setSize(750, 550);
            jsp.setLocation(250,60);
            add(jsp);
            setVisible(true);
        } 

        //Search By Producer Form
        if(e.getSource()==SearchByProducer){
            getContentPane().removeAll();
            getContentPane().repaint();
            jtf = new JTextField(15);
            searchLbl = new JLabel("Search by Producer");
            String Labels[] = { "Product ID","Product Name", "Producer"};
            
            jtf.setSize(500, 20);
            jtf.setLocation(200, 20);
            searchLbl.setSize(500, 20);
            searchLbl.setLocation(20, 20);
            String[][] ItemsList = new String[imso.productID.size()][3]; 
            for(int i=0;i<imso.productID.size();i++){
                ItemsList[i][0] = imso.productID.get(i);
                ItemsList[i][1] = imso.itemName.get(i);
                ItemsList[i][2] = imso.producer.get(i);
            }
            model = new DefaultTableModel(ItemsList, Labels);
            sorter = new TableRowSorter<>(model);
            table = new JTable(model);
            table.setRowSorter(sorter);
            jsp = new JScrollPane(table);
            
            jsp.setSize(750, 550);
            jsp.setLocation(200,60);
            add(searchLbl);
            add(jtf);
            add(jsp);
            jtf.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    search(jtf.getText());
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    search(jtf.getText());
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    search(jtf.getText());
                }
                public void search(String str) {
                    if (str.length() == 0) {
                    sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + str, 2));
                    }
                }
            });
            setVisible(true);
        } //Search by Price Event Handler
        if(e.getSource()==SearchByPrice){
            getContentPane().removeAll();
            getContentPane().repaint();
            jtf = new JTextField(15);
            searchLbl = new JLabel("Search by Price");
            String Labels[] = { "Product ID","Product Name", "Current Price"};
            jtf.setSize(500, 20);
            jtf.setLocation(200, 20);
            searchLbl.setSize(500, 20);
            searchLbl.setLocation(20, 20);
            String[][] ItemsList = new String[imso.productID.size()][3]; 
            for(int i=0;i<imso.productID.size();i++){
                ItemsList[i][0] = imso.productID.get(i);
                ItemsList[i][1] = imso.itemName.get(i);
                ItemsList[i][2] = Double.toString(imso.productPrice.get(i));
            }
            add(searchLbl);
            
            model = new DefaultTableModel(ItemsList, Labels);
            sorter = new TableRowSorter<>(model);
            table = new JTable(model);
            table.setRowSorter(sorter);
            jsp = new JScrollPane(table);
            jsp.setSize(750, 550);
            jsp.setLocation(200,60);
            add(jtf);
            add(jsp);
            jtf.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    search(jtf.getText());
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    search(jtf.getText());
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    search(jtf.getText());
                }
                public void search(String str) {
                    if (str.length() == 0) {
                    sorter.setRowFilter(null);
                    } else {
                        sorter.setRowFilter(RowFilter.regexFilter("^(?i)" + str, 2));
                        }
                }
            });
            setVisible(true);
        }
	} 
}


