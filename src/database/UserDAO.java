package database;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import beans.*;

public class UserDAO {
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String DB_URL = "jdbc:oracle:thin:@//myoracle12c.senecacollege.ca/oracle12c";
    private final String USER = "cjv805_191a44";
    private final String PASS = "23052259";
    
    public Parent getParentById(int id) {
      	 Connection connection = null;
           Statement statement = null;
           ResultSet result = null;
           Parent p = null;

           try {
               Class.forName(JDBC_DRIVER);
               connection = DriverManager.getConnection(DB_URL, USER, PASS);
               String query = "SELECT * FROM USERS WHERE USERID='" + id + "'";
               statement = connection.createStatement();
               result = statement.executeQuery(query);
               if(result.next()) {
              	 p = new Parent(result.getInt(1), result.getString(2),
                           result.getString(3),result.getString(4), 
                           result.getString(5),result.getString(6),result.getString(7),
                           result.getString(8),result.getString(9));
               }
               
           }
           catch (ClassNotFoundException cnfex){
               System.err.println("Failed to load JDBC/ODBC driver.");
           } catch (SQLException e) {
               System.out.println("The error is:  " + e.getMessage());
               e.printStackTrace();
           } finally {
               try {
                   if (result != null) {
                       result.close();
                   }
                   if (statement != null) {
                       statement.close();
                   }
                   if (connection != null) {
                       connection.close();
                   }
               } catch (SQLException e) {
                   System.out.println("Exception caught in StatementExample.main() finally block");
                   System.out.println("Exception: " + e.getMessage());
                   e.printStackTrace();
               }
           }
           return p;
       }
    

    public void insertLocationByChildId(Location l) {
    	deleteLocationByChildId(l.getLocationId());
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "INSERT INTO LOCATION VALUES(" + l.getLocationId() +", '" + l.getLatitude() + "','" + l.getLongitude() +"')";
            statement = connection.createStatement();
            result = statement.executeQuery(query);
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public Location getLocationByChildId(int id) {
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        Location l = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM LOCATION WHERE LOCATIONID = " + id;
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            if(result.next()) {
           	 l = new Location( result.getInt(1), result.getString(2),
                        result.getString(3) );
            }
            
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return l;
    }
    public void deleteLocationByChildId(int id) {
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "delete from location where locationid = " + id;
            statement = connection.createStatement();
            result = statement.executeQuery(query);  
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    public Location getLocation() {
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        Location l = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM LOCATION ";
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            if(result.next()) {
           	 l = new Location( result.getInt(1), result.getString(2),
                        result.getString(3) );
            }
            
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return l;
    }
    public void cleanLocation() {
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "delete from location";
            statement = connection.createStatement();
            result = statement.executeQuery(query);  
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public void updateLocation(Location l) {
    	cleanLocation();
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "insert into location values(1,'" + l.getLatitude() + "','" + l.getLongitude() + "')";
            statement = connection.createStatement();
            result = statement.executeQuery(query);  
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public Child getChildById(int id) {
     	 Connection connection = null;
          Statement statement = null;
          ResultSet result = null;
          Child c = null;

          try {
              Class.forName(JDBC_DRIVER);
              connection = DriverManager.getConnection(DB_URL, USER, PASS);
              String query = "SELECT * FROM CHILDREN WHERE CHILDID='" + id + "'";
              statement = connection.createStatement();
              result = statement.executeQuery(query);
              if(result.next()) {
             	 c = new Child(result.getInt(1), result.getString(2),
                          result.getString(3),result.getString(4), 
                          result.getString(5),result.getString(6),result.getString(7),
                          result.getString(8),result.getString(9), result.getInt(12));
              }
              
          }
          catch (ClassNotFoundException cnfex){
              System.err.println("Failed to load JDBC/ODBC driver.");
          } catch (SQLException e) {
              System.out.println("The error is:  " + e.getMessage());
              e.printStackTrace();
          } finally {
              try {
                  if (result != null) {
                      result.close();
                  }
                  if (statement != null) {
                      statement.close();
                  }
                  if (connection != null) {
                      connection.close();
                  }
              } catch (SQLException e) {
                  System.out.println("Exception caught in StatementExample.main() finally block");
                  System.out.println("Exception: " + e.getMessage());
                  e.printStackTrace();
              }
          }
          return c;
      }
    public List<Review> getReviewFromParent(int id){
    	List<Review> reviews = new ArrayList<Review>();
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        Review r = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "select * from review where userid=" + id;
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
            	r = new Review(result.getInt(1), result.getInt(2), result.getString(3));
            	reviews.add(r);
            }
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    	
    	return reviews;
    }
    public void deleteReviewFromParent(int id) {
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "DELETE FROM REVIEW where userid = " + id;
            statement = connection.createStatement();
            result = statement.executeQuery(query);  
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public void deleteReview(int id) {
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "DELETE FROM REVIEW where reviewid = " + id;
            statement = connection.createStatement();
            result = statement.executeQuery(query);  
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public void insertReview(int id, String reviewText) {
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "insert into review (userid, review) values (" + id + ", '" + reviewText + "')";
            statement = connection.createStatement();
            result = statement.executeQuery(query);  
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public String getParentNamebyId(int id) {
      	 Connection connection = null;
           Statement statement = null;
           ResultSet result = null;
           String name = "";
           try {
               Class.forName(JDBC_DRIVER);
               connection = DriverManager.getConnection(DB_URL, USER, PASS);
               String query = "SELECT firstName, LastName FROM USERS WHERE userid= " + id;
               statement = connection.createStatement();
               result = statement.executeQuery(query);
               if(result.next()) {
              	 name = result.getString(1) + " " + result.getString(2);
               }
               
           }
           catch (ClassNotFoundException cnfex){
               System.err.println("Failed to load JDBC/ODBC driver.");
           } catch (SQLException e) {
               System.out.println("The error is:  " + e.getMessage());
               e.printStackTrace();
           } finally {
               try {
                   if (result != null) {
                       result.close();
                   }
                   if (statement != null) {
                       statement.close();
                   }
                   if (connection != null) {
                       connection.close();
                   }
               } catch (SQLException e) {
                   System.out.println("Exception caught in StatementExample.main() finally block");
                   System.out.println("Exception: " + e.getMessage());
                   e.printStackTrace();
               }
           }
           return name;
       }
    
    public List<Review> getAllReviews(){
    	List<Review> reviews = new ArrayList<Review>();
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        Review r = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "select * from review";
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
            	r = new Review(result.getInt(1), result.getInt(2), result.getString(3));
            	reviews.add(r);
            }
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    	
    	return reviews;
    }
    public void updateParent(Parent p) {
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "UPDATE USERS SET firstname = '" + p.getFirstName() + 
            		"' , lastname = '" + p.getLastName() + "', password = '" + p.getPassword() +
            		"' , birthdate = '" + p.getBirthdate() + "', gender = '" + p.getGender() +
            		"', address = '" + p.getAddress() + "', phone = '" + p.getPhone() + 
            		"', email = '" + p.getEmail() + "' WHERE USERID = " + p.getId();
         
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    public void updateChild(Child c) {
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "update children set firstname = '" + c.getFirstName() + 
            		"' , lastname = '" + c.getLastName() + "', password = '" + c.getPassword() +
            		"' , birthdate = '" + c.getBirthdate() + "', gender = '" + c.getGender() +
            		"', address = '" + c.getAddress() + "', phone = '" + c.getPhone() + 
            		"', email = '" + c.getEmail() + "' where childid = " + c.getId();
         
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    public void deleteParentById(int id) {
    	if(getChildByParentId(id) != null) {
    		deleteChildByParentId(id);
    	}
    	if(getReviewFromParent(id) != null) {
    		deleteReviewFromParent(id);
    	}
    	
    	 Connection connection = null;
         Statement statement = null;
         ResultSet result = null;

         try {
             Class.forName(JDBC_DRIVER);
             connection = DriverManager.getConnection(DB_URL, USER, PASS);
             String query = "DELETE FROM USERS WHERE USERID = " + id ;
             statement = connection.createStatement();
             result = statement.executeQuery(query);
         }
         catch (ClassNotFoundException cnfex){
             System.err.println("Failed to load JDBC/ODBC driver.");
         } catch (SQLException e) {
             System.out.println("The error is:  " + e.getMessage());
             e.printStackTrace();
         } finally {
             try {
                 if (result != null) {
                     result.close();
                 }
                 if (statement != null) {
                     statement.close();
                 }
                 if (connection != null) {
                     connection.close();
                 }
             } catch (SQLException e) {
                 System.out.println("Exception caught in StatementExample.main() finally block");
                 System.out.println("Exception: " + e.getMessage());
                 e.printStackTrace();
             }
         }
    }
   public void deleteChildByParentId(int id) {
	   Connection connection = null;
       Statement statement = null;
       ResultSet result = null;

       try {
           Class.forName(JDBC_DRIVER);
           connection = DriverManager.getConnection(DB_URL, USER, PASS);
           String query = "DELETE FROM CHILDREN WHERE PARENTID = " + id ;
           statement = connection.createStatement();
           result = statement.executeQuery(query);
           
       }
       catch (ClassNotFoundException cnfex){
           System.err.println("Failed to load JDBC/ODBC driver.");
       } catch (SQLException e) {
           System.out.println("The error is:  " + e.getMessage());
           e.printStackTrace();
       } finally {
           try {
               if (result != null) {
                   result.close();
               }
               if (statement != null) {
                   statement.close();
               }
               if (connection != null) {
                   connection.close();
               }
           } catch (SQLException e) {
               System.out.println("Exception caught in StatementExample.main() finally block");
               System.out.println("Exception: " + e.getMessage());
               e.printStackTrace();
           }
       }
   }
   
    public void deleteChildById(int id) {
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "DELETE FROM CHILDREN WHERE CHILDID = " + id ;
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public List<Child> getChildByParentId(int id){
    	List<Child> children = new ArrayList<Child>();
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        Child c = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM CHILDREN WHERE PARENTID = " + id ;
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
            	c = new Child(result.getInt(1), result.getString(2),
            			result.getString(3),result.getString(4), 
            			result.getString(5),result.getString(6),result.getString(7),
            			result.getString(8),result.getString(9), result.getInt(12));
            	children.add(c);
            }
            
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    	
    	return children;
    }
    
    public List<Parent> getAllParents() {
    	List<Parent> parents = new ArrayList<Parent>();
    	Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        Parent p = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM USERS";
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) {
           	 p = new Parent(result.getInt(1), result.getString(2),
                        result.getString(3),result.getString(4), 
                        result.getString(5),result.getString(6),result.getString(7),
                        result.getString(8),result.getString(9));
           	 parents.add(p);
            }
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    	return parents;
    }
    
    public Parent getParentByEmail(String email) {
   	 Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        Parent p = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String query = "SELECT * FROM USERS WHERE EMAIL='" + email + "'";
            statement = connection.createStatement();
            result = statement.executeQuery(query);
            if(result.next()) {
           	 p = new Parent(result.getInt(1), result.getString(2),
                        result.getString(3),result.getString(4), 
                        result.getString(5),result.getString(6),result.getString(7),
                        result.getString(8),result.getString(9));
            }
            
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return p;
    }
    
    public void registerParent(Parent p) {
    	  Connection connection = null;
          Statement statement = null;
          ResultSet resultSet = null;

          try {
              Class.forName(JDBC_DRIVER);
              connection = DriverManager.getConnection(DB_URL, USER, PASS);

              statement = connection.createStatement();
              String query = "INSERT INTO USERS(firstname, lastname, password, birthdate, gender, address, phone, email, isparent, isadmin) values("
              		 + "'" + p.getFirstName() + "',"
              		 + "'" + p.getLastName() + "',"
              		 + "'" + p.getPassword() + "',"
              		 + "'" + p.getBirthdate() + "',"
              		 + "'" + p.getGender() + "',"
              		 + "'" + p.getAddress() + "',"
              		 + "'" + p.getPhone() + "',"
              		 + "'" + p.getEmail() + "',"
              		 + "'" + p.getIsParent() + "',"
              		 + "'" + p.getIsAdmin() + "')";
              resultSet = statement.executeQuery(query);
              resultSet.next();
          }
          catch (ClassNotFoundException cnfex){
              System.err.println("Failed to load JDBC/ODBC driver.");
          } catch (SQLException e) {
              System.out.println("The error is:  " + e.getMessage());
              e.printStackTrace();
          } finally {
              try {
                  if (resultSet != null) {
                      resultSet.close();
                  }
                  if (statement != null) {
                      statement.close();
                  }
                  if (connection != null) {
                      connection.close();
                  }
              } catch (SQLException e) {
                  System.out.println("Exception caught in StatementExample.main() finally block");
                  System.out.println("Exception: " + e.getMessage());
                  e.printStackTrace();
              }
          }
      }
    public void registerChild(Child c) {
  	  Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            statement = connection.createStatement();
            String query = "INSERT INTO CHILDREN(firstname, lastname, password, birthdate, gender, address, phone, email, isparent, isadmin, parentid) values("
            		 + "'" + c.getFirstName() + "',"
            		 + "'" + c.getLastName() + "',"
            		 + "'" + c.getPassword() + "',"
            		 + "'" + c.getBirthdate() + "',"
            		 + "'" + c.getGender() + "',"
            		 + "'" + c.getAddress() + "',"
            		 + "'" + c.getPhone() + "',"
            		 + "'" + c.getEmail() + "',"
              		 + "'" + c.getIsParent() + "',"
              		 + "'" + c.getIsAdmin() + "',"
              		 + "'" + c.getParentId() + "')";
            resultSet = statement.executeQuery(query);
            resultSet.next();
        }
        catch (ClassNotFoundException cnfex){
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    public Child getChildByEmail(String email) {
      	 Connection connection = null;
           Statement statement = null;
           ResultSet result = null;
           Child c = null;

           try {
               Class.forName(JDBC_DRIVER);
               connection = DriverManager.getConnection(DB_URL, USER, PASS);
               String query = "SELECT * FROM CHILDREN WHERE EMAIL='" + email + "'";
               statement = connection.createStatement();
               result = statement.executeQuery(query);
               if(result.next()) {
              	 c = new Child(result.getInt(1), result.getString(2),
                           result.getString(3),result.getString(4), 
                           result.getString(5),result.getString(6),result.getString(7),
                           result.getString(8),result.getString(9), result.getInt(12));
               }
               
           }
           catch (ClassNotFoundException cnfex){
               System.err.println("Failed to load JDBC/ODBC driver.");
           } catch (SQLException e) {
               System.out.println("The error is:  " + e.getMessage());
               e.printStackTrace();
           } finally {
               try {
                   if (result != null) {
                       result.close();
                   }
                   if (statement != null) {
                       statement.close();
                   }
                   if (connection != null) {
                       connection.close();
                   }
               } catch (SQLException e) {
                   System.out.println("Exception caught in StatementExample.main() finally block");
                   System.out.println("Exception: " + e.getMessage());
                   e.printStackTrace();
               }
           }
           return c;
       }
    
    public Admin getAdminByEmail(String email) {
     	 Connection connection = null;
          Statement statement = null;
          ResultSet result = null;
          Admin a = null;

          try {
              Class.forName(JDBC_DRIVER);
              connection = DriverManager.getConnection(DB_URL, USER, PASS);
              String query = "SELECT * FROM ADMIN WHERE EMAIL='" + email + "'";
              statement = connection.createStatement();
              result = statement.executeQuery(query);
              if(result.next()) {
             	 a = new Admin(result.getInt(1), result.getString(2),
                          result.getString(3),result.getString(4), 
                          result.getString(5),result.getString(6),result.getString(7),
                          result.getString(8),result.getString(9));
              }
          
          }
          catch (ClassNotFoundException cnfex){
              System.err.println("Failed to load JDBC/ODBC driver.");
          } catch (SQLException e) {
              System.out.println("The error is:  " + e.getMessage());
              e.printStackTrace();
          } finally {
              try {
                  if (result != null) {
                      result.close();
                  }
                  if (statement != null) {
                      statement.close();
                  }
                  if (connection != null) {
                      connection.close();
                  }
              } catch (SQLException e) {
                  System.out.println("Exception caught in StatementExample.main() finally block");
                  System.out.println("Exception: " + e.getMessage());
                  e.printStackTrace();
              }
          }
          return a;
      }
    
}
