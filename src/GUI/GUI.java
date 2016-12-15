package GUI;

import DB.DBConnection;
import DB.EmployeesIdentity;
import HRPackage.Employee;
import Session.Session;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel; 

public class GUI extends JFrame {

    // panels
    private JPanel greetingPanel, mainPanel = new JPanel(), employeeTab,
            employeePanel, employeeSearchPanel, hourlyEmpTab, salaryEmpTab,
            commissionEmpTab, productTab, productPanel, manufacturerPanel,
            productSearchPanel, exitPanel;
    // tabs
    private JTabbedPane mainTabs, employeeTypeTab;

    // main labels
    private JLabel helloLbl;

    // labels for employee tab
    private JLabel firstNameLbl, 
            lastNameLbl, 
            addressLbl, 
            phoneNumberLbl,
            yearLbl, 
            monthLbl, 
            dayLbl, 
            weeklySalaryLbl, 
            hoursLbl, 
            hourRateLbl,
            salesLbl, 
            commissionRateLbl, 
            baseSalaryLbl, 
            searchEmpResultsLbl,
            searchProductResultsLbl,
    //added new generic labels for employee creation
            emphireDateYearlbl,
            empHireDateMonthlbl,
            empHireDateDaylbl,
            empSinlbl,
            empPositionlbl,
            empGenderlbl,
            empDepartmentlbl,
            empStatuslbl;

            

    // text boxes for employee tab
    private JTextField firstNameTxt = new JTextField(15),
            lastNameTxt = new JTextField(15),
            addressTxt = new JTextField(15),
            phoneNumberTxt = new JTextField(15),
            yearTxt = new JTextField(15),
            monthTxt = new JTextField(15),
            dayTxt = new JTextField(15),
            searchEmployeeTxt = new JTextField(15),
            weeklySalaryTxt = new JTextField(15),
            hoursTxt = new JTextField(15),
            hourRateTxt = new JTextField(15),
            salesTxt = new JTextField(15),
            commissionRateTxt = new JTextField(15),
            baseSalaryTxt = new JTextField(15),
            //new submission fields added for employee creation
            
            emphireDateYearTxt = new JTextField(15),
            empHireDateMonthTxt = new JTextField(15),
            empHireDateDayTxt = new JTextField(15),
            empSinTxt = new JTextField(15),
            empPositionTxt = new JTextField(15),
            empGenderTxt = new JTextField(15),
            empDepartmentTxt = new JTextField(15),
            empStatusTxt = new JTextField(15);
    

    // labels for product tab
    private JLabel productNameLbl, productPriceLbl, manufacturerNameLbl,
            manufacturerCountryLbl, searchProductLbl;
    // text boxes for product tab
    private JTextField productNameTxt = new JTextField(15),
            productPriceTxt = new JTextField(15),
            manufacturerNameTxt = new JTextField(15),
            manufacturerCountryTxt = new JTextField(15),
            searchProductTxt = new JTextField(15);

    // textareas for search results
    private JTextArea searchEmpResults, searchProductResults;

    // buttons
    private JButton createHourlyEmployeeBtn, createSalaryEmployeeBtn,
            createCommEmployeeBtn, createProductBtn, searchEmployeeBtn,
            searchProductBtn, exitBtn;
    
    
    //search area panel, removed into sub section for ease of coding.
    
    //required check boxes for building search criteria, Ben Dunn. 
    // <editor-fold>
    private JCheckBox 
            searchEmpIDSelectedCheckBox = new JCheckBox(),
            searchEmpTypeSelectedCheckBo = new JCheckBox(),
            searchFirstNameSelectedCheckBox = new JCheckBox(),
            searchLastNameSelectedCheckBox = new JCheckBox(), 
            searchPositionSelectedCheckBox = new JCheckBox(),
            searchGenderSelectedCheckBox = new JCheckBox(),
            
            searchDepartmentSelectedCheckBox = new JCheckBox(), 
            searchSinSelectedCheckBox = new JCheckBox(), 
            searchBirthdaySelectedCheckBox = new JCheckBox(), 
            searchHiredateSelectedCheckBox = new JCheckBox(),
            searchStatusSelectedCheckBox = new JCheckBox(),
            searchPhoneSelectedCheckBox = new JCheckBox(),
            searchAddressSelectedCheckBox = new JCheckBox();
    
    //Labels
    private JLabel 
            searchEmpIDlbl = new JLabel("Employee ID: "), 
            searchEmpTypelbl = new JLabel("Employee Type: "), 
            searchFirstNamelbl = new JLabel("First Name: "),
            searchLastNamelbl = new JLabel("Last Name: "),
            searchPositionlbl= new JLabel("Position: "),
            searchGenderlbl = new JLabel("Gender: "),
            searchDepartmentlbl = new JLabel("Department: "), 
            searchSinlbl = new JLabel("Sin Number: "),
            searchBirthdaylbl = new JLabel("Birthday: "),
            searchHiredatelbl = new JLabel("Hire Date: "),
            searchStatuslbl = new JLabel("Status: "),
            searchPhonelbl = new JLabel("Phone Number: "),
            searchAddresslbl = new JLabel("Address: ");
    
    //Search areas based on user input
    private JTextArea 
            searchEmpIDTextBox = new JTextArea(3, 20),//emptype is dropdown
            searchFirstNameTextBox = new JTextArea(3, 20), 
            searchLastNameTextBox= new JTextArea(3, 20), 
            searchPositionTextBox= new JTextArea(3, 20),
            searchGenderTextBox= new JTextArea(3, 20), 
            searchDepartmentTextBox= new JTextArea(3, 20), 
            searchSinTextBox= new JTextArea(3, 20),
            searchbirthDayTextBox= new JTextArea(3, 20), 
            searchHireDateTextBox= new JTextArea(3, 20), 
            searchStatusTextBox= new JTextArea(3, 20),
            searchPhoneTextBox= new JTextArea(3, 20), 
            searchAddressTextBox= new JTextArea(3, 20),
    
            //text fields for editing an employee. 
            searchEDITEmpIDTextBox = new JTextArea(1, 20),//emptype is dropdown
            searchEDITFirstNameTextBox = new JTextArea(1, 20), 
            searchEDITLastNameTextBox= new JTextArea(1, 20), 
            searchEDITPositionTextBox= new JTextArea(1, 20),
            searchEDITGenderTextBox= new JTextArea(1, 20), 
            searchEDITDepartmentTextBox= new JTextArea(1, 20), 
            searchEDITSinTextBox= new JTextArea(1, 20),
            searchEDITbirthDayTextBox= new JTextArea(1, 20), 
            searchEDITHireDateTextBox= new JTextArea(1, 20), 
            searchEDITStatusTextBox= new JTextArea(1, 20),
            searchEDITPhoneTextBox= new JTextArea(1, 20), 
            searchEDITAddressTextBox= new JTextArea(1, 20);
    private JPanel 
            searchEditUpperPanel = new JPanel(), 
            searchEditLowerPanel = new JPanel(), 
            searchEditMainMain = new JPanel();
    
    
    
    private JButton
            searchEmpEditButton = new JButton("Edit"),
            searchEmpDeleteButton = new JButton("Delete"),
            searchEmpSubmitEditButton = new JButton("Submit Changes");
            
    
    // </editor-fold>
    
    //table layout for view, is overriding hte cell editable to
    //prevent a user from changing data from the table model
    JTable searchResultsTable = new JTable() {
        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {                
                return false;               
        };
    };;
    
    private Employee[] employeeStorage;
    private Employee selectedEmployee; 
    JScrollPane searchResultsScrollTable; //accessor. 
    DefaultTableModel searchResultsDefaultTableModel; 
    
    //JPanel panel = new JPanel();
    
    //layouts for search
    private JPanel 
            searchMainPanel, //divided in half 
            searchResultsPanel, //right side
            searchCriteriaPanel, //upper lower divided in half (no center)
            searchCriteriaButtonsPanel, //holds the search button for a gridlayout. 
            searchCriteriaEntryPanel; //holds the areas. 
    
    
    //created by reference to classes. 
    private JComboBox searchEmpTypeComboBox = new JComboBox (new String[] 
    {"Commission Employee",
    "Hourly Employee",
    "Salary Employee"} );
    
    //buttons
    private JButton searchEmployees; //activates the search for the database. 
    //SimpleVectorTable SearchResultsVectors = new SimpleVectorTable(); //results holder object
    //listeners
    SearchButtonListener searchBtnListener;
    
    //end of ben search initalization 

    // form font
    private Font mainFont = new Font("Verdana", Font.PLAIN, 14);

    // form border
    private Border mainBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

    // interface constructor
    public GUI(Session session) {

        // set title layout and 
        super("Assignment 3.");
        setLayout(new FlowLayout());

        // create tabs
        mainTabs = new JTabbedPane();

        // create main panels
        buildGreetingsPanel("Welcome to Assignment 3.");
        buildEmployeeTab();
        buildProductTab();
        buildExitPanel();
        this.buildSearchPanel();

        // add tabs
        mainTabs.addTab("Employee", null, employeeTab, "Employee");
        mainTabs.addTab("Products", null, productTab, "Products");
        mainTabs.addTab("Search Employees", null, this.searchMainPanel, "Search Employees");

        // add subpanels to main panel
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(greetingPanel, BorderLayout.NORTH);
        mainPanel.add(mainTabs, BorderLayout.CENTER);
        mainPanel.add(exitPanel, BorderLayout.SOUTH);

        add(mainPanel);
        
        // prevent resize. 
        this.pack();
        this.setResizable(false);
    }
    
        
    private void buildSearchPanel () {
        //init panels
        this.searchMainPanel = new JPanel();
        this.searchResultsPanel = new JPanel();
        this.searchCriteriaPanel = new JPanel();
        this.searchCriteriaButtonsPanel = new JPanel();
        this.searchCriteriaEntryPanel = new JPanel(); 
        
        
        //System.out.println(this.SearchResultsVectors.getColumnNames().toString());
        searchResultsTable = new JTable(this.searchResultsDefaultTableModel);
        //searchResultsTable.add
        //        empJTableListSelectionListener
        
        //set all important layouts. 
        this.searchMainPanel.setLayout(new BorderLayout());
        this.searchCriteriaPanel.setLayout(new BorderLayout());
        this.searchCriteriaEntryPanel.setLayout(new GridLayout(0,3));
        this.searchCriteriaButtonsPanel.setLayout(new GridLayout(0,1));
        this.searchResultsPanel.setLayout(new BorderLayout());
        
        //add searchButton for executing Queries. 
        this.searchEmployees = new JButton("Search DataBase for Employee");
        this.searchBtnListener = new SearchButtonListener(); 
        this.searchEmployees.addActionListener(this.searchBtnListener);
        this.searchEmployees.doClick(); //force a click
        this.searchResultsDefaultTableModel = searchBtnListener.returnMyTable();
        //this.searchBtnListener.actionPerformed(new ActionEvent());
        this.searchCriteriaButtonsPanel.add(this.searchEmployees);
        
        
        
        
        //add the components to the criteria entry panel;
       
        // <editor-fold>
        this.searchCriteriaEntryPanel.add(this.searchEmpIDlbl);
        this.searchCriteriaEntryPanel.add(this.searchEmpIDSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchEmpIDTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchEmpTypelbl);
        this.searchCriteriaEntryPanel.add(this.searchEmpTypeSelectedCheckBo);
        this.searchCriteriaEntryPanel.add(this.searchEmpTypeComboBox); // combo box
        
        
        this.searchCriteriaEntryPanel.add(this.searchFirstNamelbl);
        this.searchCriteriaEntryPanel.add(this.searchFirstNameSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchFirstNameTextBox);
        
      
        this.searchCriteriaEntryPanel.add(this.searchLastNamelbl);
        this.searchCriteriaEntryPanel.add(this.searchLastNameSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchLastNameTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchPositionlbl);
        this.searchCriteriaEntryPanel.add(this.searchPositionSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchPositionTextBox);
       
        
        
        this.searchCriteriaEntryPanel.add(this.searchGenderlbl);
        this.searchCriteriaEntryPanel.add(this.searchGenderSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchGenderTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchDepartmentlbl);
        this.searchCriteriaEntryPanel.add(this.searchDepartmentSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchDepartmentTextBox);
        
        
        
        this.searchCriteriaEntryPanel.add(this.searchSinlbl);
        this.searchCriteriaEntryPanel.add(this.searchSinSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchSinTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchBirthdaylbl);
        this.searchCriteriaEntryPanel.add(this.searchBirthdaySelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchbirthDayTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchHiredatelbl);
        this.searchCriteriaEntryPanel.add(this.searchHiredateSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchHireDateTextBox);
        
        
        this.searchCriteriaEntryPanel.add(this.searchStatuslbl);
        this.searchCriteriaEntryPanel.add(this.searchStatusSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchStatusTextBox);
        
        
        this.searchCriteriaEntryPanel.add(this.searchPhonelbl);
        this.searchCriteriaEntryPanel.add(this.searchPhoneSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchPhoneTextBox);
        
        this.searchCriteriaEntryPanel.add(this.searchAddresslbl);
        this.searchCriteriaEntryPanel.add(this.searchAddressSelectedCheckBox);
        this.searchCriteriaEntryPanel.add(this.searchAddressTextBox);
        // </editor-fold>
        
        //empJTableListSelectionListener
        
        searchResultsTable.setModel(this.searchResultsDefaultTableModel);
        //this.searchResultsTable = new JTable(this.searchResultsDefaultTableModel);
        this.searchResultsTable.setSize(300, 800);
        
            try {
            //placed inline as this is merely setup. 
                for (int i = 1; i <= (searchResultsTable.getColumnCount()); i++) 
                {
                    searchResultsTable.getColumn(i).setPreferredWidth(150);
                } 
            }
            catch (Exception e ) {
                System.out.println(e.getMessage());
                //errorWriter.writeError(e);
            }
            
            //searchEmpEditButton.addActionListener();
            searchEmpDeleteButton.addActionListener(new DeleteButtonListener());
            this.searchEmpEditButton.addActionListener(new SelectForEditListener());
            JPanel searchEditDeletePanel = new JPanel(); 
            searchEditDeletePanel.setLayout(new GridLayout(0,2));
            searchEditDeletePanel.add(searchEmpDeleteButton);
            searchEditDeletePanel.add(this.searchEmpEditButton);
            
            
        this.searchResultsTable.doLayout(); //auto adusts the table. 
        
        System.out.println(this.searchResultsDefaultTableModel.getDataVector().size());
        this.buildSearchPanelSelection();
        //add the components to the results set panel
        this.searchResultsScrollTable = new JScrollPane(this.searchResultsTable); 
        
        
        this.searchResultsPanel.add(this.searchResultsScrollTable, BorderLayout.NORTH);
        //this.searchResultsPanel.add(this.searchEditMainMain, BorderLayout.CENTER);
        this.searchResultsPanel.add(searchEditDeletePanel, BorderLayout.SOUTH);
        
        this.searchCriteriaPanel.add(this.searchCriteriaEntryPanel,BorderLayout.NORTH);
        this.searchCriteriaPanel.add(this.searchCriteriaButtonsPanel, BorderLayout.SOUTH);
        this.searchMainPanel.add(this.searchCriteriaPanel, BorderLayout.WEST); //searchResultsPanel
        this.searchMainPanel.add(this.searchResultsPanel, BorderLayout.EAST);
        
    }
    
    private void buildSearchPanelSelection() {
            searchEditUpperPanel.setLayout(new GridLayout(0,2));
            searchEditLowerPanel.setLayout(new GridLayout(0,1));
            searchEditMainMain = new JPanel(new BorderLayout());
            
            //searchEditUpperPanel.add(searchEDITEmpIDTextBox);
            searchEditUpperPanel.add(new JLabel("First Name"));
            searchEditUpperPanel.add(searchEDITFirstNameTextBox);
            searchEditUpperPanel.add(new JLabel("Last Name"));
            searchEditUpperPanel.add(searchEDITLastNameTextBox);
            searchEditUpperPanel.add(new JLabel("Position"));
            searchEditUpperPanel.add(searchEDITPositionTextBox);
            searchEditUpperPanel.add(new JLabel("Gender"));
            searchEditUpperPanel.add(searchEDITGenderTextBox );
            searchEditUpperPanel.add(new JLabel("Department"));
            searchEditUpperPanel.add(searchEDITDepartmentTextBox );
            searchEditUpperPanel.add(new JLabel("Sin Number"));
            searchEditUpperPanel.add(searchEDITSinTextBox);
            searchEditUpperPanel.add(new JLabel("Status"));
            searchEditUpperPanel.add(searchEDITStatusTextBox);
            searchEditUpperPanel.add(new JLabel("Phone"));
            searchEditUpperPanel.add(searchEDITPhoneTextBox );
            searchEditUpperPanel.add(new JLabel("Address"));
            searchEditUpperPanel.add(searchEDITAddressTextBox);
            searchEmpSubmitEditButton.addActionListener(new UpdateButtonListener());
            this.searchEditLowerPanel.add(this.searchEmpSubmitEditButton);
            searchEditMainMain.add(this.searchEditUpperPanel, BorderLayout.NORTH);
            searchEditMainMain.add(this.searchEditLowerPanel, BorderLayout.SOUTH);
    }
    
    //build query tab for general searching of the employees 

    // build panels 
    // build greeting panel
    private void buildGreetingsPanel(String greetMessage) {
        greetingPanel = new JPanel();
        helloLbl = new JLabel(greetMessage);
        helloLbl.setFont(mainFont);
        greetingPanel.add(helloLbl);
        greetingPanel.setBorder(mainBorder);
    }

    // build employee tab and subpanels
    private void buildEmployeeTab() {
        // create tab
        employeeTab = new JPanel();
        buildEmployeePanel();
        buildEmployeeTypeTab();
        buildEmployeeSearchPanel();

        // set layout and add all subpanels to employee tab
        employeeTab.setLayout(new BorderLayout());
        employeeTab.add(employeePanel, BorderLayout.NORTH);
        employeeTab.add(employeeTypeTab, BorderLayout.SOUTH);
        //employeeTab.add(employeeSearchPanel, BorderLayout.SOUTH);
    }

    private void buildEmployeePanel() {
        // create new panel
        employeePanel = new JPanel();
        // set grid
        employeePanel.setLayout(new GridLayout(0, 2));
        // set border
        employeePanel.setBorder(BorderFactory.createTitledBorder("Employee info"));
        // set labels
        firstNameLbl = new JLabel("First Name");
        lastNameLbl = new JLabel("Last Name");
        addressLbl = new JLabel("Address");
        phoneNumberLbl = new JLabel("Phone Number");
        yearLbl = new JLabel("Year of birth");
        monthLbl = new JLabel("Month of birth");
        dayLbl = new JLabel("Day of birth");
        
        //added code
        emphireDateYearlbl = new JLabel("Year of Hire");
        empHireDateMonthlbl = new JLabel("Month of Hire");
        empHireDateDaylbl = new JLabel("Day of Hire");
        empSinlbl = new JLabel("Sin Number");
        empPositionlbl = new JLabel("Position");
        empGenderlbl = new JLabel("Gender");
        empDepartmentlbl = new JLabel("Deparment");
        empStatuslbl =  new JLabel("First Name");
        
        

        // add everything to panel
        employeePanel.add(firstNameLbl);
        employeePanel.add(firstNameTxt);
        employeePanel.add(lastNameLbl);
        employeePanel.add(lastNameTxt);
        employeePanel.add(addressLbl);
        employeePanel.add(addressTxt);
        employeePanel.add(phoneNumberLbl);
        employeePanel.add(phoneNumberTxt);
        employeePanel.add(yearLbl);
        employeePanel.add(yearTxt);
        employeePanel.add(monthLbl);
        employeePanel.add(monthTxt);
        employeePanel.add(dayLbl);
        employeePanel.add(dayTxt);
        //added code new inputs
        employeePanel.add(emphireDateYearlbl);
        employeePanel.add(emphireDateYearTxt);
        employeePanel.add(empHireDateMonthlbl);
        employeePanel.add(empHireDateMonthTxt);
        employeePanel.add(empHireDateDaylbl);
        employeePanel.add(empHireDateDayTxt);
        employeePanel.add(empSinlbl);
        employeePanel.add(empSinTxt);
        employeePanel.add(empPositionlbl);
        employeePanel.add(empPositionTxt);
        employeePanel.add(empGenderlbl);
        employeePanel.add(empGenderTxt);
        employeePanel.add(empDepartmentlbl); 
        employeePanel.add(empDepartmentTxt);
        employeePanel.add(empStatuslbl);
        employeePanel.add(empStatusTxt);
        
        
        
    }

    private void buildEmployeeTypeTab() {
        // create new tabs
        employeeTypeTab = new JTabbedPane();
        buildHourlyEmployeePanel();
        buildSalaryEmployeePanel();
        buildCommissionEmployeePanel();
        // add panels to tabs
        employeeTypeTab.addTab("Hourly Emp", null, hourlyEmpTab, "Hourly Emp");
        employeeTypeTab.addTab("Salary Emp", null, salaryEmpTab, "Salary Emp");
        employeeTypeTab.addTab("Commission Emp", null, commissionEmpTab, "Commission Emp");
    }

    // build three subpanels for each employee type
    private void buildHourlyEmployeePanel() {
        // create new panel
        hourlyEmpTab = new JPanel();
        // set grid
        hourlyEmpTab.setLayout(new GridLayout(3, 2));
        // set border
        hourlyEmpTab.setBorder(BorderFactory.createTitledBorder("Create Hourly Employee"));
        // set labels
        hoursLbl = new JLabel("Hours");
        hourRateLbl = new JLabel("Hour Rate");
        // create button
        createHourlyEmployeeBtn = new JButton("Create Hourly Employee");
        // add everything to panel
        hourlyEmpTab.add(hoursLbl);
        hourlyEmpTab.add(hoursTxt);
        hourlyEmpTab.add(hourRateLbl);
        hourlyEmpTab.add(hourRateTxt);
        hourlyEmpTab.add(createHourlyEmployeeBtn);

    }

    private void buildSalaryEmployeePanel() {
        // create new panel
        salaryEmpTab = new JPanel();
        // set grid
        salaryEmpTab.setLayout(new GridLayout(2, 2));
        // set border
        salaryEmpTab.setBorder(BorderFactory.createTitledBorder("Create Salary Employee"));
        // set labels
        weeklySalaryLbl = new JLabel("Weekly salary");
        // create button
        createSalaryEmployeeBtn = new JButton("Create Salary Employee");
        // add everything to panel
        salaryEmpTab.add(weeklySalaryLbl);
        salaryEmpTab.add(weeklySalaryTxt);
        salaryEmpTab.add(createSalaryEmployeeBtn);
    }

    private void buildCommissionEmployeePanel() {
        // create new panel
        commissionEmpTab = new JPanel();
        // set grid
        commissionEmpTab.setLayout(new GridLayout(4, 2));
        // set border
        commissionEmpTab.setBorder(BorderFactory.createTitledBorder("Create Commission Employee"));
        // set labels
        salesLbl = new JLabel("Sales");
        commissionRateLbl = new JLabel("Commission Rate");
        baseSalaryLbl = new JLabel("Base salary");
        // create button
        createCommEmployeeBtn = new JButton("Create Commission Employee");
        // add everything to panel
        commissionEmpTab.add(salesLbl);
        commissionEmpTab.add(salesTxt);
        commissionEmpTab.add(commissionRateLbl);
        commissionEmpTab.add(commissionRateTxt);
        commissionEmpTab.add(baseSalaryLbl);
        commissionEmpTab.add(baseSalaryTxt);
        commissionEmpTab.add(createCommEmployeeBtn);
    }

    private void buildEmployeeSearchPanel() {
        // create new panel
        employeeSearchPanel = new JPanel();
        // set grid
        employeeSearchPanel.setLayout(new GridLayout(4, 1));
        // set border
        employeeSearchPanel.setBorder(BorderFactory.createTitledBorder("Search Employee"));
        // set labels
        searchEmpResultsLbl = new JLabel("Search results:");
        // create text area for search results
        searchEmpResults = new JTextArea(3, 20);
        // create button
        searchEmployeeBtn = new JButton("Search");
        // add everything to panel
        employeeSearchPanel.add(searchEmployeeTxt);
        employeeSearchPanel.add(searchEmployeeBtn);
        employeeSearchPanel.add(searchEmpResultsLbl);
        employeeSearchPanel.add(searchEmpResults);
    }

    // build product tab and subpanels
    private void buildProductTab() {
        // create new tab
        productTab = new JPanel();
        buildProductPanel();
        buildManufacturerPanel();
        buildProductSearchPanel();
        // set layout and add all subpanels to product tab
        productTab.setLayout(new BorderLayout());
        productTab.add(productPanel, BorderLayout.NORTH);
        productTab.add(manufacturerPanel, BorderLayout.CENTER);
        productTab.add(productSearchPanel, BorderLayout.SOUTH);
    }

    private void buildProductPanel() {
        // create new panel
        productPanel = new JPanel();
        // set grid
        productPanel.setLayout(new GridLayout(2, 2));
        // set border
        productPanel.setBorder(BorderFactory.createTitledBorder("Product basic info"));
        // set labels
        productNameLbl = new JLabel("Product name");
        productPriceLbl = new JLabel("Price");

        // add everything to panel
        productPanel.add(productNameLbl);
        productPanel.add(productNameTxt);
        productPanel.add(productPriceLbl);
        productPanel.add(productPriceTxt);

    }

    private void buildManufacturerPanel() {
        // create new panel
        manufacturerPanel = new JPanel();
        // set grid
        manufacturerPanel.setLayout(new GridLayout(5, 1));
        // set border
        manufacturerPanel.setBorder(BorderFactory.createTitledBorder("Manufacturer info"));
        // set labels
        manufacturerNameLbl = new JLabel("Manufacturer name");
        manufacturerCountryLbl = new JLabel("Country");

        // create product button
        createProductBtn = new JButton("Create product");

        // add everything to panel
        manufacturerPanel.add(manufacturerNameLbl);
        manufacturerPanel.add(manufacturerNameTxt);
        manufacturerPanel.add(manufacturerCountryLbl);
        manufacturerPanel.add(manufacturerCountryTxt);
        manufacturerPanel.add(createProductBtn);

    }

    private void buildProductSearchPanel() {
        // create new panel
        productSearchPanel = new JPanel();
        // set grid
        productSearchPanel.setLayout(new GridLayout(4, 1));
        // set border
        productSearchPanel.setBorder(BorderFactory.createTitledBorder("Search product by name"));
        // set labels
        searchProductResultsLbl = new JLabel("Search results:");
        // create search button
        searchProductBtn = new JButton("Search");
        // create text area for search results
        searchProductResults = new JTextArea(3, 20);

        // add everything to panel
        productSearchPanel.add(searchProductTxt);
        productSearchPanel.add(searchProductBtn);
        productSearchPanel.add(searchProductResultsLbl);
        productSearchPanel.add(searchProductResults);
    }

    // build bottom panel with exit button
    private void buildExitPanel() {
        exitPanel = new JPanel();
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ExitButtonListener());
        exitPanel.add(exitBtn);
    }

    /**
     * Sets up either a search criteria of values (1), or sections (2) 
     * @param setupFlag
     * @return 
     */
    private String[] createEmpSearchCriteria (int setupFlag)  {
        ArrayList<String> temp = new ArrayList<String>();
        
        if (this.searchEmpIDSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add(this.searchEmpIDTextBox.getText());
            } 
            else if (setupFlag == 2) {
                temp.add("EmpID");
            }
            
        }
        //comboBox.getSelectedItem().toString()
        if (this.searchEmpTypeSelectedCheckBo.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add(this.searchEmpTypeComboBox.toString());
            } 
            else if (setupFlag == 2) {
                temp.add("EmpType");
            }
            
        }
        if (this.searchFirstNameSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchFirstNameTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("firstName");
            }
            
        }
        if (this.searchLastNameSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchLastNameTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("lastName");
            }
        }
        
        if (this.searchPositionSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchPositionTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("position");
            }
            
        }
        if (this.searchGenderSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchGenderTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("gender");
            }
        }
        if (this.searchDepartmentSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchDepartmentTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("department");
            }
            
        }
        if (this.searchSinSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchSinTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("sin");
            }
        }
        if (this.searchBirthdaySelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchbirthDayTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("birthDate");
            }
            
        }
        if (this.searchHiredateSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchHireDateTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("hireDate");
            }
        }
        
        if (this.searchStatusSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchStatusTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("status");
            }
        }
        if (this.searchPhoneSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'"+this.searchPhoneTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("phone");
            }
        }
        if (this.searchAddressSelectedCheckBox.isSelected() == true) {
            if (setupFlag == 1) {
                temp.add("'" + this.searchAddressTextBox.getText()+"'");
            } 
            else if (setupFlag == 2) {
                temp.add("address");
            }
        }
        
        // String [] stockArr = stockList.toArray(new String[stockList.size()]);
        //could probably do this in a statement, but brain fried. 
        
        String[] returnValue = temp.toArray(new String[temp.size()]);
        
        return returnValue;
        
    }

/**
 * Creates an SQL string statement to pull from a database. Created by Ben
 * Dunn. 
 * @param SearchCriteria
 * @param searchKey
 * @param TableName
 * @return a string representing the SQL query that will need to be run on
 * the datadbase. 
 * @throws IndexOutOfBoundsException 
 */
    private String searchSetup (String[] SearchCriteria, String[] searchKey, String TableName) 
    throws IndexOutOfBoundsException
    {
        System.out.println("Reached Creation of statement");
        //throw the exception if the searchKeys.legnth =! SearchCriteria
        if (SearchCriteria.length!=searchKey.length) {
            throw new IndexOutOfBoundsException("Array sizes are not equal in search criteria"); 
        } //no issues. 
        
        
        String searchString = "SELECT * FROM " + TableName + " ";
        //System.out.println(searchString);
        try {
        for (int k =0; k<= SearchCriteria.length-1; k++) 
        {
            
            //flip the switch for and/where queries. 
            if (k == 0) {
                searchString += "WHERE ";
            }
            else {
                searchString += "AND ";
            }
            searchString += SearchCriteria[k] + " = " + searchKey[k]; //add the value to the end. 
            
        }} catch (IndexOutOfBoundsException e) {
            //errorWriter.writeError(e);
            System.out.println("index of the legnth was out of bounds");
        }
        
        
        searchString += ";";
        //debug system out for checking
        System.out.println("Query = " + searchString);
        
        return searchString; 
        
    }
    
    

    private void deleteEmployee() {
        int Delete = this.employeeStorage[this.searchResultsTable.getSelectedRow()].getEmpId();
        //this.employeeStorage[0];
        DBConnection conn = new DBConnection(); 
        try {
            conn.deleteSQLDataBase("Employee","EmpID", Delete);
            this.searchEmployees.doClick(); //force and update through an event click
        } catch(Exception e)
        {
            
            System.out.println("Delete Error" + e.getMessage());
        };
    }    
    
    private void updateEmployee() {
        try {
        selectedEmployee.setSinNumber(Integer.getInteger(searchEDITSinTextBox.getText()));
        } catch (Exception e) {}
        selectedEmployee.setFirstName(searchEDITFirstNameTextBox.getText());
        selectedEmployee.setLastName(searchEDITLastNameTextBox.getText());
        selectedEmployee.setPosition(searchEDITPositionTextBox.getText());
        selectedEmployee.setGender(searchEDITGenderTextBox.getText());
        selectedEmployee.setStatus(searchEDITStatusTextBox.getText());
        selectedEmployee.setPhoneNumber(searchEDITPhoneTextBox.getText());
        selectedEmployee.setAddress(searchEDITAddressTextBox.getText());
        UpdateEmployee();
    }
    
    public void UpdateEmployee() {
        DBConnection conn = new DBConnection();
        conn.updateSQLDataBase("Employee", "firstName", selectedEmployee.getFirstName(), "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "lastName", selectedEmployee.getLastName(), "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "position", selectedEmployee.getPosition(), "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "gender", selectedEmployee.getGender(), "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "status", selectedEmployee.getStatus(), "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "Phone", selectedEmployee.getPhoneNumber(), "EmpID", selectedEmployee.getEmpId());
        conn.updateSQLDataBase("Employee", "addess", selectedEmployee.getAddress(), "EmpID", selectedEmployee.getEmpId());
        this.searchEmployeeBtn.doClick();
    }
    

    
    private class empJTableListSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent event) {
            System.out.println("This is Done: " + searchResultsTable.getSelectedRow());
            selectedEmployee = employeeStorage[searchResultsTable.getSelectedRow()];
        }
    }
    
    private class SelectForEditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
             EditWindow editWindow = new EditWindow();
             editWindow.setVisible(true);
        }
    }
    
    private class EditWindow extends JFrame {
        
        public EditWindow() {
            //searchEDITEmpIDTextBox.setText(selectedEmployee.get
            searchEDITFirstNameTextBox.setText(selectedEmployee.getFirstName());
            searchEDITLastNameTextBox .setText(selectedEmployee.getLastName());
            searchEDITPositionTextBox.setText(selectedEmployee.getPosition());
            searchEDITGenderTextBox.setText(selectedEmployee.getGender());
            //searchEDITDepartmentTextBox.setText(selectedEmployee);
            searchEDITSinTextBox.setText(String.valueOf(selectedEmployee.getSinNumber()));
            //searchEDITbirthDayTextBox.setText(selectedEmployee.get
            //searchEDITHireDateTextBox.setText(selectedEmployee
            searchEDITStatusTextBox.setText(selectedEmployee.getStatus());
            searchEDITPhoneTextBox .setText(selectedEmployee.getPhoneNumber());
            searchEDITAddressTextBox.setText(selectedEmployee.getAddress());
            this.add(searchEditMainMain);
            this.pack();
        }
    }
    
    private class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            updateEmployee(); 
        }
    } 
    
    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            deleteEmployee();
        }
    }
    
   

    /**
     * Action listener for updating and searching the tables. 
     */
    public class SearchButtonListener implements ActionListener {
        /***
         * private inner class with overwritten table to prevent editing.
         */

        private EmployeesIdentity empIden;


 //action listener's table
        @Override
        public void actionPerformed(ActionEvent event) {
            //call and execute the query 
            
                try {
                    //System.out.println("Hey I did fucking shit!");
                    DBConnection Conn = new DBConnection(); 
                    empIden = Conn.getEmployeeInformation(searchSetup(createEmpSearchCriteria(2), 
                            createEmpSearchCriteria(1), "gc200325005.Employee"));

                    searchResultsTable.setModel(empIden.getEmpTable());
                    employeeStorage = empIden.getEmpArrayReturn();
                    System.out.println("Size of Current employeeStorage array: "+ employeeStorage.length);

            }catch (Exception e) {
                //errorWriter.writeError(e);
                System.out.println("Error!");
                System.out.println(e.getMessage());
            }
            
        }
        /**
         * 
         * @return the table model for the search results if needed. 
         */
        public DefaultTableModel returnMyTable() {
            return this.empIden.getEmpTable();
        }
        
        
    }

    // event handlers
    // close form
    private class ExitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            // are you sure box
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION) == 0) {
                System.exit(0);
            }
        }
        
        
    }

}
