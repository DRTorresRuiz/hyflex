package VRP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Instance {

    private ArrayList<Location> demands = new ArrayList<Location>();
    private String instanceName;
    private int vehicleNumber;
    private int vehicleCapacity;
    private Location depot;

    public Instance( int id ) {

        String fileName = "data/vrp/";
        if ( id == 0 ) {
            fileName += ( "Solomon_100_customer_instances/C/C101.txt" );
        } else if ( id == 1 ) {
            fileName += ( "Solomon_100_customer_instances/C/C102.txt" );
        } else if ( id == 2 ) {
            fileName += ( "Solomon_100_customer_instances/C/C103.txt" );
        } else if ( id == 3 ) {
            fileName += ( "Solomon_100_customer_instances/C/C104.txt" );
        } else if ( id == 4 ) {
            fileName += ( "Solomon_100_customer_instances/C/C105.txt" );
        } else if ( id == 5 ) {
            fileName += ( "Solomon_100_customer_instances/C/C106.txt" );
        } else if ( id == 6 ) {
            fileName += ( "Solomon_100_customer_instances/C/C107.txt" );
        } else if ( id == 7 ) {
            fileName += ( "Solomon_100_customer_instances/C/C108.txt" );
        } else if ( id == 8 ) {
            fileName += ( "Solomon_100_customer_instances/C/C109.txt" );
        } else if ( id == 9 ) {
            fileName += ( "Solomon_100_customer_instances/C/C201.txt" );
        } else if ( id == 10 ) {
            fileName += ( "Solomon_100_customer_instances/C/C202.txt" );
        } else if ( id == 11 ) {
            fileName += ( "Solomon_100_customer_instances/C/C203.txt" );
        } else if ( id == 12 ) {
            fileName += ( "Solomon_100_customer_instances/C/C204.txt" );
        } else if ( id == 13 ) {
            fileName += ( "Solomon_100_customer_instances/C/C205.txt" );
        } else if ( id == 14 ) {
            fileName += ( "Solomon_100_customer_instances/C/C206.txt" );
        } else if ( id == 15 ) {
            fileName += ( "Solomon_100_customer_instances/C/C207.txt" );
        } else if ( id == 16 ) {
            fileName += ( "Solomon_100_customer_instances/C/C208.txt" );
        } else if ( id == 17 ) {
            fileName += ( "Solomon_100_customer_instances/R/R101.txt" );
        } else if ( id == 18 ) {
            fileName += ( "Solomon_100_customer_instances/R/R102.txt" );
        } else if ( id == 19 ) {
            fileName += ( "Solomon_100_customer_instances/R/R103.txt" );
        } else if ( id == 20 ) {
            fileName += ( "Solomon_100_customer_instances/R/R104.txt" );
        } else if ( id == 21 ) {
            fileName += ( "Solomon_100_customer_instances/R/R105.txt" );
        } else if ( id == 22 ) {
            fileName += ( "Solomon_100_customer_instances/R/R106.txt" );
        } else if ( id == 23 ) {
            fileName += ( "Solomon_100_customer_instances/R/R107.txt" );
        } else if ( id == 24 ) {
            fileName += ( "Solomon_100_customer_instances/R/R108.txt" );
        } else if ( id == 25 ) {
            fileName += ( "Solomon_100_customer_instances/R/R109.txt" );
        } else if ( id == 26 ) {
            fileName += ( "Solomon_100_customer_instances/R/R110.txt" );
        } else if ( id == 27 ) {
            fileName += ( "Solomon_100_customer_instances/R/R111.txt" );
        } else if ( id == 28 ) {
            fileName += ( "Solomon_100_customer_instances/R/R112.txt" );
        } else if ( id == 29 ) {
            fileName += ( "Solomon_100_customer_instances/R/R201.txt" );
        } else if ( id == 30 ) {
            fileName += ( "Solomon_100_customer_instances/R/R202.txt" );
        } else if ( id == 31 ) {
            fileName += ( "Solomon_100_customer_instances/R/R203.txt" );
        } else if ( id == 32 ) {
            fileName += ( "Solomon_100_customer_instances/R/R204.txt" );
        } else if ( id == 33 ) {
            fileName += ( "Solomon_100_customer_instances/R/R205.txt" );
        } else if ( id == 34 ) {
            fileName += ( "Solomon_100_customer_instances/R/R206.txt" );
        } else if ( id == 35 ) {
            fileName += ( "Solomon_100_customer_instances/R/R207.txt" );
        } else if ( id == 36 ) {
            fileName += ( "Solomon_100_customer_instances/R/R208.txt" );
        } else if ( id == 37 ) {
            fileName += ( "Solomon_100_customer_instances/R/R209.txt" );
        } else if ( id == 38 ) {
            fileName += ( "Solomon_100_customer_instances/R/R210.txt" );
        } else if ( id == 39 ) {
            fileName += ( "Solomon_100_customer_instances/R/R211.txt" );
        } else if ( id == 40 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC101.txt" );
        } else if ( id == 41 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC102.txt" );
        } else if ( id == 42 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC103.txt" );
        } else if ( id == 43 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC104.txt" );
        } else if ( id == 44 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC105.txt" );
        } else if ( id == 45 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC106.txt" );
        } else if ( id == 46 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC107.txt" );
        } else if ( id == 47 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC108.txt" );
        } else if ( id == 48 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC201.txt" );
        } else if ( id == 49 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC202.txt" );
        } else if ( id == 50 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC203.txt" );
        } else if ( id == 51 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC204.txt" );
        } else if ( id == 52 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC205.txt" );
        } else if ( id == 53 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC206.txt" );
        } else if ( id == 54 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC207.txt" );
        } else if ( id == 55 ) {
            fileName += ( "Solomon_100_customer_instances/RC/RC208.txt" );
        } else if ( id == 56 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C1_10_1.txt" );
        } else if ( id == 57 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C1_10_2.txt" );
        } else if ( id == 58 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C1_10_3.txt" );
        } else if ( id == 59 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C1_10_4.txt" );
        } else if ( id == 60 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C1_10_5.txt" );
        } else if ( id == 61 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C1_10_6.txt" );
        } else if ( id == 62 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C1_10_7.txt" );
        } else if ( id == 63 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C1_10_8.txt" );
        } else if ( id == 64 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C1_10_9.txt" );
        } else if ( id == 65 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C1_10_10.txt" );
        } else if ( id == 66 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C2_10_1.txt" );
        } else if ( id == 67 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C2_10_2.txt" );
        } else if ( id == 68 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C2_10_3.txt" );
        } else if ( id == 69 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C2_10_4.txt" );
        } else if ( id == 70 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C2_10_5.txt" );
        } else if ( id == 71 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C2_10_6.txt" );
        } else if ( id == 72 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C2_10_7.txt" );
        } else if ( id == 73 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C2_10_8.txt" );
        } else if ( id == 74 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C2_10_9.txt" );
        } else if ( id == 75 ) {
            fileName += ( "Homberger_1000_customer_instances/C/C2_10_10.txt" );
        } else if ( id == 76 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R1_10_1.txt" );
        } else if ( id == 77 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R1_10_2.txt" );
        } else if ( id == 78 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R1_10_3.txt" );
        } else if ( id == 79 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R1_10_4.txt" );
        } else if ( id == 80 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R1_10_5.txt" );
        } else if ( id == 81 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R1_10_6.txt" );
        } else if ( id == 82 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R1_10_7.txt" );
        } else if ( id == 83 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R1_10_8.txt" );
        } else if ( id == 84 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R1_10_9.txt" );
        } else if ( id == 85 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R1_10_10.txt" );
        } else if ( id == 86 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R2_10_1.txt" );
        } else if ( id == 87 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R2_10_2.txt" );
        } else if ( id == 88 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R2_10_3.txt" );
        } else if ( id == 89 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R2_10_4.txt" );
        } else if ( id == 90 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R2_10_5.txt" );
        } else if ( id == 91 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R2_10_6.txt" );
        } else if ( id == 92 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R2_10_7.txt" );
        } else if ( id == 93 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R2_10_8.txt" );
        } else if ( id == 94 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R2_10_9.txt" );
        } else if ( id == 95 ) {
            fileName += ( "Homberger_1000_customer_instances/R/R2_10_10.txt" );
        } else if ( id == 96 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC1_10_1.txt" );
        } else if ( id == 97 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC1_10_2.txt" );
        } else if ( id == 98 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC1_10_3.txt" );
        } else if ( id == 99 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC1_10_4.txt" );
        } else if ( id == 100 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC1_10_5.txt" );
        } else if ( id == 101 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC1_10_6.txt" );
        } else if ( id == 102 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC1_10_7.txt" );
        } else if ( id == 103 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC1_10_8.txt" );
        } else if ( id == 104 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC1_10_9.txt" );
        } else if ( id == 105 ) {
            fileName
                    += ( "Homberger_1000_customer_instances/RC/RC1_10_10.txt" );
        } else if ( id == 106 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC2_10_1.txt" );
        } else if ( id == 107 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC2_10_2.txt" );
        } else if ( id == 108 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC2_10_3.txt" );
        } else if ( id == 109 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC2_10_4.txt" );
        } else if ( id == 110 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC2_10_5.txt" );
        } else if ( id == 111 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC2_10_6.txt" );
        } else if ( id == 112 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC2_10_7.txt" );
        } else if ( id == 113 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC2_10_8.txt" );
        } else if ( id == 114 ) {
            fileName += ( "Homberger_1000_customer_instances/RC/RC2_10_9.txt" );
        } else if ( id == 115 ) {
            fileName
                    += ( "Homberger_1000_customer_instances/RC/RC2_10_10.txt" );
        }

        BufferedReader reader = null;
        try {
            FileReader read = new FileReader( fileName );
            reader = new BufferedReader( read );
        } catch ( FileNotFoundException a ) {
            try {
                InputStream fis = this.getClass().getClassLoader()
                        .getResourceAsStream( fileName );
                reader = new BufferedReader( new InputStreamReader( fis ) );
            } catch ( NullPointerException n ) {
                System.err.println( "cannot find file " + fileName );
                System.exit( -1 );
            }
        }//end catch


        try {
            instanceName = reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();
            StringTokenizer info = new StringTokenizer( reader.readLine() );
            vehicleNumber   = Integer.parseInt( info.nextToken() );
            vehicleCapacity = Integer.parseInt( info.nextToken() );
            reader.readLine();
            reader.readLine();
            reader.readLine();
            reader.readLine();
            String line = "";
            while ( ( line = reader.readLine() ) != null ) {
                info = new StringTokenizer( line );
                Location loc = new Location(
                        Integer.parseInt( info.nextToken() ),
                        Integer.parseInt( info.nextToken() ),
                        Integer.parseInt( info.nextToken() ),
                        Integer.parseInt( info.nextToken() ),
                        Integer.parseInt( info.nextToken() ),
                        Integer.parseInt( info.nextToken() ),
                        Integer.parseInt( info.nextToken() )
                );
                demands.add( loc );
            }
            setDepot( demands.get( 0 ) );
			/*
			System.out.println("Instance name is " + instanceName + ", there
			are " + vehicleNumber + " vehicles with capacity of " +
			vehicleCapacity);
			for(int i=0; i<demands.size(); i++)
			{
				Location l = demands.get(i);
				System.out.println("For location " + l.getId() + ", at (" + l
				.getXCoord() + "," + l.getYCoord() + "), demand is " + l
				.getDemand() + ", ready time is " + l.getReadyTime() + ", due
				time is " + l.getDueDate() + " and service time is " + l
				.getServiceTime());
			}
			 */
        } catch ( IOException e ) {
            System.out.println( "Exception found: " + e );
            System.out.println(
                    "Could not load instance, or instance does not exist" );
            System.exit( -1 );
        }
    }

    public ArrayList<Location> getDemands() {

        return demands;
    }

    public void setDemands( ArrayList<Location> demands ) {

        this.demands = demands;
    }

    public String getInstanceName() {

        return instanceName;
    }

    public void setInstanceName( String instanceName ) {

        this.instanceName = instanceName;
    }

    public int getVehicleNumber() {

        return vehicleNumber;
    }

    public void setVehicleNumber( int vehicleNumber ) {

        this.vehicleNumber = vehicleNumber;
    }

    public int getVehicleCapacity() {

        return vehicleCapacity;
    }

    public void setVehicleCapacity( int vehicleCapacity ) {

        this.vehicleCapacity = vehicleCapacity;
    }

    public void setDepot( Location depot ) {

        this.depot = depot;
    }

    public Location getDepot() {

        return depot;
    }
}
