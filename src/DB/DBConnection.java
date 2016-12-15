// Class that contain DB connection variables and all queries
// All ID's are generated inside DB, so never add ID for INSERT statements.
package DB;

import HRPackage.*;
import Session.Session;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


// class that store connection variables
public class DBConnection {

    Statement stat = null;
    Connection conn = null;
    ResultSet rs = null;
    final String DB_URL
            = "jdbc:mysql://sql.computerstudi.es:3306/gc200325005";
    final String DB_Username = "gc200325005";
    final String DB_Password = "nMWC7cP-";
    
    //general user login information. 
    
    /**
     * Creates a login object and returns a session. 
     * @param userName
     * @param PassWord
     * @return 
     */
    public Session loginRequest (String userName, String PassWord) {
        Session session = new Session ("Something has gone wrong");
        
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            if (conn != null) {
                stat = conn.createStatement();
                rs = stat.executeQuery("SELECT * "
                        + "FROM gc200325005.Login " +
                        "WHERE UserName ='"+userName+"' " +
                        "And PassWord = '"+PassWord +"' " + 
                        "LIMIT 1");
                // pull a login session from the DB. Pull and unpack
                if(rs != null) {
                    // create customer object, we need to move it to another location,
                    // not the best place to create customer object

                    DefaultTableModel tableResults = buildTBModel(rs);
                    
                    //System.out.println(tableResults.toString()); Debug
                    System.out.println(tableResults.getValueAt(0, 0).toString());
                    System.out.println(tableResults.getValueAt(0, 1).toString());
                    System.out.println(tableResults.getValueAt(0, 2).toString());
                    System.out.println(tableResults.getValueAt(0, 3).toString());
                    
                    try {
                    session = new Session(
                            Integer.parseInt(tableResults.getValueAt(0, 0).toString()),
                            tableResults.getValueAt(0, 1).toString(),
                            tableResults.getValueAt(0, 2).toString(),
                            Boolean.getBoolean(tableResults.getValueAt(0, 3).toString()));
                    //userLogged = new Customer(rs.getString("login"),rs.getInt("custID"),rs.getBoolean("admin"));
                    } 
                    catch (Exception e) {
                        session = new Session ("Something has gone wrong with creating the user session!");
                    }
                    
                                        
                    //newLogin(rs.getInt("custID"));
                } else {
                    session =  new Session("User Account Was not found"); 
                }
                
            }
            
        } catch (Exception e) { //other error messages caused by other values. 
            session = new Session(e.getMessage()); 
        } 
        return session; 
            
    }
    
    /**
     * Queries the database and gets an encapsulated object with a table
     * and array of employees. 
     * @param EmpTableQuery
     * @return 
     */
    public EmployeesIdentity getEmployeeInformation (String EmpTableQuery) {
        DefaultTableModel tempTable; //initialize place holder
                tempTable = querySQLDataBase(EmpTableQuery); //set variable
                System.out.println("EmpTableQuery: "
                        + "\n The Table Size for creating the EMP obects: "
                        +tempTable.getColumnCount());
                buildEmployeeArray(tempTable);
                return new EmployeesIdentity(buildEmployeeArray(tempTable),tempTable );    
    }
    
    
    /***
     * Returns a table based on a query to the database that is constructed
     * from the items in the GUI. 
     * @param query
     * @return 
     */
    public DefaultTableModel querySQLDataBase (String query) {
        try {
            System.out.println(query);
            conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            if (conn != null) {
                stat = conn.createStatement(); 
                return buildTBModel(rs = stat.executeQuery(query)); 
            }
            } catch(SQLException e) {
                System.out.println("Something has gone wrong with the SQL: " + e.getMessage());
                
            } catch (Exception e) {
                System.out.println("Something has gone wrong with the Query: " + e.getMessage());
            }
        return new DefaultTableModel(); //incase anything goes wrong return
            
    } 
    



    // insert new row to DB
    public void insert(String TableName) {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            stat = conn.createStatement();

            
            

        } catch (SQLException err) {

        }
    }

    
    


    // update row at DB
    public void updateSQLDataBase(String TableName, String columnName, String columnData, String key, int rowID) {
        
        String updateString = "UPDATE " + TableName + " SET " + columnName + " = " + columnData
                +" WHERE " + key + " = " + rowID +";";
        System.out.println(updateString);
        try {
        conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            stat = conn.createStatement();
            stat.executeUpdate(updateString);
            
        }catch(Exception ex) {
            
        }
        
    }


    /**
    * Deletes from the DB the user. 
     * @param TableName
    * @param IDType
    * @param ID
     * @throws SQLException 
     */
    public void deleteSQLDataBase(String TableName, String IDType, int ID) throws SQLException {

		
               
                conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
                
                /*
                DELETE 
                FROM gc200325005.Employee
                WHERE EMPID = 1;
                */
                
		String deleteStatement = "DELETE FROM "+ TableName+ " WHERE "+IDType+ " = " +ID;
                System.out.println("Delete statement :" + deleteStatement);
		try {
                     stat = conn.createStatement(); 
                     stat.executeUpdate(deleteStatement); 
			
		} catch (SQLException e) {



		} finally {


		}

	}


    /**
     * turns table into an array of employees
     * @param empTable
     * @return Employee[]
     */
    
    public Employee[] buildEmployeeArray (DefaultTableModel empTable) {
        System.out.println("About to build Data for employees");
         ArrayList<Employee> empTempArryList = new ArrayList<Employee>();
         try {
             for (int k = 0; k<= empTable.getRowCount()-1;k++) {

                 //setup and clear variables
                             String FN = " ";
                             String LN = " ";
                             String Add = " ";
                             String PhnN = " ";
                             String Gen = " ";
                             String Pos = " ";
                             String Dept = " ";
                             int sin = 0;
                             double earns =0;
                             // dates
                             int BY = 0;
                             int BM = 0;
                             int BD = 0;
                             int HY = 0;
                             int HM = 0;
                             int HD = 0;
                             
                             //specifics
                             double payRate = 0.0;
                             double hours = 0.0;
                             double salary = 0.0;
                             double sales = 0.0;
                             double commissionRate = 0.0;
                             double totalSalary = 0.0; 
                             
                             int empID =Integer.parseInt(empTable.getValueAt(k, 0).toString());//want this to throw an error
                            try {
                                FN = preventNull(empTable.getValueAt(k, 2).toString(),0);
                            } catch(Exception e){};try {
                                LN = preventNull(empTable.getValueAt(k, 3).toString(),0);
                            } catch(Exception e){};try {
                                Add = preventNull(empTable.getValueAt(k, 12).toString(),0);
                            } catch(Exception e){};try {
                                PhnN = preventNull(empTable.getValueAt(k, 8).toString(),0);
                            } catch(Exception e){};try {
                                Gen =  preventNull(empTable.getValueAt(k, 5).toString(),0);
                            } catch(Exception e){};try {
                            Pos =  preventNull(empTable.getValueAt(k, 8).toString(),0);
                            } catch(Exception e){};try {
                                Dept =  preventNull(empTable.getValueAt(k, 6).toString(),0);
                            } catch(Exception e){};try {
                                sin = Integer.parseInt( preventNull(empTable.getValueAt(k, 7).toString(),0));
                            } catch(Exception e){};try {
                                earns = Double.parseDouble( preventNull(empTable.getValueAt(k, 13).toString(),0));
                            } catch(Exception e){};
                             // dates
                           
                            try {
                                BY = this.pullDate( preventNull(empTable.getValueAt(k, 8).toString(),1), 1);
                                BM = this.pullDate( preventNull(empTable.getValueAt(k, 8).toString(),1), 2);
                                BD = this.pullDate( preventNull(empTable.getValueAt(k, 8).toString(),1), 3);
                            } catch(Exception e){};
                            try {
                                HY = this.pullDate( preventNull(empTable.getValueAt(k, 9).toString(),1), 1);
                                HM = this.pullDate( preventNull(empTable.getValueAt(k, 9).toString(),1), 2);
                                HD = this.pullDate( preventNull(empTable.getValueAt(k, 9).toString(),1), 3);
                            } catch(Exception e){};
                             System.out.println("Reached here without error");
                             
                            
                            //comm rate
                 if (Integer.parseInt(empTable.getValueAt(k, 1).toString()) == 0) {
                    try {sales = Double.parseDouble( preventNull(empTable.getValueAt(k, 13).toString(),17)); } catch(Exception e){};
                    try {commissionRate = Double.parseDouble( preventNull(empTable.getValueAt(k, 13).toString(),18)); } catch(Exception e){};
                        
                    CommissionEmployee tempEmp = new CommissionEmployee(empID, FN,LN,Add,PhnN,Gen,Pos,Dept,sin,earns,BY,BM,BD,HY,HM,HD,commissionRate);
                    tempEmp.setTotalSales(sales); //as it was restricted in the orginal class
                    empTempArryList.add(tempEmp);
                }
                 else if (Integer.parseInt(empTable.getValueAt(k, 1).toString()) == 1) {
                    try {payRate = Double.parseDouble( preventNull(empTable.getValueAt(k, 13).toString(),14)); } catch(Exception e){};
                    try {hours = Double.parseDouble( preventNull(empTable.getValueAt(k, 13).toString(),14)); } catch(Exception e){};     
                    
                    HourlyEmployee tempEmp = new HourlyEmployee(empID, FN,LN,Add,PhnN,Gen,Pos,Dept,sin,earns,BY,BM,BD,HY,HM,HD,payRate);
                    tempEmp.setHoursWorked(hours); //as it was restricted in the orginal class
                    empTempArryList.add(tempEmp);
                 } else if (Integer.parseInt(empTable.getValueAt(k, 1).toString()) == 1) {
                    try {salary = Double.parseDouble( preventNull(empTable.getValueAt(k, 13).toString(),16)); } catch(Exception e){};
                    try {totalSalary = Double.parseDouble( preventNull(empTable.getValueAt(k, 13).toString(),19)); } catch(Exception e){};
                    SalaryEmployee tempEmp = new SalaryEmployee(empID, FN,LN,Add,PhnN,Gen,Pos,Dept,sin,earns,BY,BM,BD,HY,HM,HD,salary);
                    empTempArryList.add(tempEmp);

                 }
             
             }
         }catch (Exception e) {
             System.out.println("Error In employee array creation :" + e.getMessage());
             return null;
         }
         return empTempArryList.toArray(new Employee[empTempArryList.size()]);
         
    }
    /**
     * Converts a date string from SQL databases into a series of ints
     * 1 = year
     * 2 = month
     * 3 = day
     * @param dateString
     * @param MDY
     * @return 
     */
    private int pullDate (String dateString, int MDY) {
        try{
            if (MDY == 1)
            {
                return Integer.parseInt(dateString.substring(0,4));
            }else if (MDY == 2) {
                return Integer.parseInt((dateString).substring(5,7));
            }else if (MDY == 3) {
                return Integer.parseInt((dateString).substring(8,9));
            }else {
                return 0;
            }
        } catch(Exception e) {
            System.out.println("Date conversion error: " + e.getMessage());
        } //YYYY-MM-DD
        return 0; //if a fail happens, however will never reach. 
        
        
    }
    
    private String preventNull (String in, int Op) {
        try {
            System.out.println("Safe Test Value: " + in);
            if (in != null) {
            
                return in;
            } else {
                if(Op == 1) {
                    return "0";
            }
                else {
                    return " ";
                }
            }
        } catch (Exception e) 
        {
            if(Op == 1) {return "0";}
            else {return " ";}
        } //final catch on the conversion
    }
    
    /**
     * Returned values as default table model, JTables need 
     * a different constructor, made a new simpleVectorTable to 
     * correct this problem 
     * @param rs
     * @return
     * @throws SQLException 
     */
    public static DefaultTableModel buildTBModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        
                Vector<String> columnNames = new Vector<String>();
        // column count
        int columnCount = metaData.getColumnCount();
        System.out.println("Column Count: " + metaData.getColumnCount());
        System.out.println("Reached data Meta Data: "+ metaData.getColumnName(1));

        //System.out.println("Column Count:"+ columnCount);
        //System.out.println("Reached A");
        // loop to build the column names
        
            for (int i = 0; i < columnCount; i++) {
                columnNames.add(metaData.getColumnName(i+1)); //index for table names are 1 greater
                System.out.println(metaData.getColumnName(i+1));
            }

        // create the Vector to hold the data (Vectoe of Vectors)
        Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();

         //System.out.println("Reached B");
        // go throught the resultset
        while (rs.next()) {
            System.out.println("Running Row: ");
            // this will store each row
            Vector<Object> rowVector = new Vector<Object>();
            // loop through the result set and get each object
            try {
            for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                rowVector.add(rs.getObject(colIndex));
                //System.out.println(rs.getObject(colIndex).toString());
            }
            tableData.add(rowVector);
            } catch (Exception e) {
            //System.out.println("Hey This is where the fuck up is");
            System.out.println(e.getMessage());
        }
        }

        System.out.println("Final Table Size: " + tableData.size());
        //System.out.println("Reached C");
        // return
        return new DefaultTableModel(tableData, columnNames);
    }


    /**
     * no longer supported login method. 
     * @param login
     * @param password
     * @return 
     */
    public boolean systemLogin(String login, String password) {
        int dbLoopCounter = 0;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
            if (conn != null) {
                // create the statement object that will manipulate with DB
                stat = conn.createStatement();
                rs = stat.executeQuery("SELECT * FROM Login WHERE login = `" + 
                        login + "` AND password = `" + password + "` LIMIT 1");

                if(rs != null) {
                    // create customer object, we need to move it to another location,
                    // not the best place to create customer object
                    //userLogged = new Customer(rs.getString("login"),rs.getInt("custID"),rs.getBoolean("admin"));
                    //newLogin(rs.getInt("custID"));
                    
                } else {
                        JOptionPane.showMessageDialog(null, "Your Credentials were invalid. Please try again!");
                }
                rs.close();
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Your Credentials were invalid. Please try again!");
            dbLoopCounter++;

            if (dbLoopCounter > 2) {
                JOptionPane.showMessageDialog(null, "Failure to authenticate to database. System will exit.");
                System.exit(0);
            }
        }
        
        return false;
    }



}
