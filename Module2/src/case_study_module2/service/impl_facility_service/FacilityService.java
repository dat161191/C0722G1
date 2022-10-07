package case_study_module2.service.impl_facility_service;

import case_study_module2.model.Facility.Facility;
import case_study_module2.model.Facility.House;
import case_study_module2.model.Facility.Room;
import case_study_module2.model.Facility.Villa;
import case_study_module2.service.IFacilityService;
import case_study_module2.util.FuramaCheckException;
import case_study_module2.util.FuramaException;

import java.io.*;
import java.util.*;

public class FacilityService implements IFacilityService {
    private static final Scanner scanner = new Scanner(System.in);
    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    private static Map<Facility, Integer> facilityMaintenance = new LinkedHashMap<>();
    private static final List<Facility> facilityList = new ArrayList<>();
    private static final List<Room> roomList = new ArrayList<>();
    private static final List<Villa> villaList = new ArrayList<>();
    private static final List<House> houseList = new ArrayList<>();
    private static final String linkFacility = "src/case_study_module2/data/FacilityInput.csv";
    private static final String linkFacilityMaintenace = "src/case_study_module2/data/FacilityMaintenace.csv";

    @Override
    public void displayFacility() {
        facilityMap = readFile(linkFacility);
        Set<Facility> keys = facilityMap.keySet();
        for (Facility key : keys) {
            System.out.println("Key: " + key + "," + facilityMap.get(key));
        }
    }


    @Override
    public void addFacility() {

    }

    @Override
    public void addFacilityMaintenance() {
        facilityMap = readFile(linkFacility);
        Set<Facility> key = facilityMap.keySet();
        for (Facility i : key) {
            if (facilityMap.get(i) >=5) {
                facilityMaintenance.put(i, facilityMap.get(i));
            }
        }
        writeFile(facilityMaintenance, linkFacilityMaintenace);
    }

    @Override
    public void displayFacilityMaintenance() {
        addFacilityMaintenance();
        facilityMaintenance = readFile(linkFacilityMaintenace);
        Set<Facility> keys = facilityMaintenance.keySet();
        for (Facility i : keys) {
            System.out.println("Key: " + i + "," + facilityMaintenance.get(i));
        }

    }

    @Override
    public void addHouse() {
        facilityMap = readFile(linkFacility);
        facilityMap.put(infoHouse(), 0);
        writeFile(facilityMap, linkFacility);
    }

    @Override
    public void addRoom() {
        facilityMap = readFile(linkFacility);
        facilityMap.put(infoRoom(), 0);
        writeFile(facilityMap, linkFacility);
    }

    @Override
    public void addVilla() {
        facilityMap = readFile(linkFacility);
        facilityMap.put(infoVilla(), 0);
        writeFile(facilityMap, linkFacility);
    }

    private Villa infoVilla() {
        String serviceName;
        while (true) {
            try {
                System.out.println("Enter Service Name to be corrected!");
                serviceName = scanner.nextLine();
                FuramaCheckException.checkServiceName(serviceName);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        double usableArea;
        while (true) {
            try {
                System.out.println("Enter UsableArea to be corrected!");
                usableArea = Double.parseDouble(scanner.nextLine());
                FuramaCheckException.checkUsableArea(usableArea);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        double rentalCosts;
        while (true) {
            try {
                System.out.println("Enter RentalCosts to be corrected!");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                FuramaCheckException.checkRentalCoats(rentalCosts);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        int maximumPeople;
        while (true) {
            try {
                System.out.println("Enter MaximumPeople to be corrected!");
                maximumPeople = Integer.parseInt(scanner.nextLine());
                FuramaCheckException.checkMaxPeople(maximumPeople);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String rentalType;
        while (true) {
            try {
                System.out.println("Enter RentalType to be corrected!");
                rentalType = scanner.nextLine();
                FuramaCheckException.checkRentalType(rentalType);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceCode;
        while (true) {
            try {
                System.out.println("Enter ServiceCode to be corrected!");
                serviceCode = scanner.nextLine();
                FuramaCheckException.checkServiceCodeVilla(serviceCode);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String roomStandard;
        while (true) {
            try {
                System.out.println("Enter RoomStandard to be corrected!");
                roomStandard = scanner.nextLine();
                FuramaCheckException.checkRoomStandard(roomStandard);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        double poolArea;
        while (true) {
            try {
                System.out.println("Enter PoolArea to be corrected!");
                poolArea = Double.parseDouble(scanner.nextLine());
                FuramaCheckException.checkPoolArea(poolArea);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        int numFoor;
        while (true) {
            try {
                System.out.println("Enter NumberFoor to be corrected!");
                numFoor = Integer.parseInt(scanner.nextLine());
                FuramaCheckException.checkNumberFloor(numFoor);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }

        return new Villa(serviceName, usableArea, rentalCosts, maximumPeople, rentalType, serviceCode, roomStandard, poolArea, numFoor);
    }

    private Room infoRoom() {
        String serviceName;
        while (true) {
            try {
                System.out.println("Enter Service Name to be corrected!");
                serviceName = scanner.nextLine();
                FuramaCheckException.checkServiceName(serviceName);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        double usableArea;
        while (true) {
            try {
                System.out.println("Enter UsableArea to be corrected!");
                usableArea = Double.parseDouble(scanner.nextLine());
                FuramaCheckException.checkUsableArea(usableArea);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        double rentalCosts;
        while (true) {
            try {
                System.out.println("Enter RentalCosts to be corrected!");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                FuramaCheckException.checkRentalCoats(rentalCosts);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        int maximumPeople;
        while (true) {
            try {
                System.out.println("Enter MaximumPeople to be corrected!");
                maximumPeople = Integer.parseInt(scanner.nextLine());
                FuramaCheckException.checkMaxPeople(maximumPeople);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String rentalType;
        while (true) {
            try {
                System.out.println("Enter RentalType to be corrected!");
                rentalType = scanner.nextLine();
                FuramaCheckException.checkRentalType(rentalType);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceCode;
        while (true) {
            try {
                System.out.println("Enter ServiceCode to be corrected!");
                serviceCode = scanner.nextLine();
                FuramaCheckException.checkServiceCodeRoom(serviceCode);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String freeService;
        while (true) {
            try {
                System.out.println("Enter FreeService to be corrected!");
                freeService = scanner.nextLine();
                FuramaCheckException.checkFreeService(freeService);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return new Room(serviceName, usableArea, rentalCosts, maximumPeople, rentalType, serviceCode, freeService);
    }

    private House infoHouse() {
        String serviceName;
        while (true) {
            try {
                System.out.println("Enter Service Name to be corrected!");
                serviceName = scanner.nextLine();
                FuramaCheckException.checkServiceName(serviceName);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        double usableArea;
        while (true) {
            try {
                System.out.println("Enter UsableArea to be corrected!");
                usableArea = Double.parseDouble(scanner.nextLine());
                FuramaCheckException.checkUsableArea(usableArea);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        double rentalCosts;
        while (true) {
            try {
                System.out.println("Enter RentalCosts to be corrected!");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                FuramaCheckException.checkRentalCoats(rentalCosts);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        int maximumPeople;
        while (true) {
            try {
                System.out.println("Enter MaximumPeople to be corrected!");
                maximumPeople = Integer.parseInt(scanner.nextLine());
                FuramaCheckException.checkMaxPeople(maximumPeople);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String rentalType;
        while (true) {
            try {
                System.out.println("Enter RentalType to be corrected!");
                rentalType = scanner.nextLine();
                FuramaCheckException.checkRentalType(rentalType);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceCode;
        while (true) {
            try {
                System.out.println("Enter ServiceCode to be corrected!");
                serviceCode = scanner.nextLine();
                FuramaCheckException.checkServiceCodeHouse(serviceCode);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        String roomStandard;
        while (true) {
            try {
                System.out.println("Enter RoomStandard to be corrected!");
                roomStandard = scanner.nextLine();
                FuramaCheckException.checkRoomStandard(roomStandard);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        int numberFloor;
        while (true) {
            try {
                System.out.println("Enter NumberFloor to be corrected!");
                numberFloor = Integer.parseInt(scanner.nextLine());
                FuramaCheckException.checkNumberFloor(numberFloor);
                break;
            } catch (FuramaException e) {
                System.out.println(e.getMessage());
            }
        }
        return new House(serviceName, usableArea, rentalCosts, maximumPeople, rentalType, serviceCode, roomStandard, numberFloor);
    }

    public Map<Facility, Integer> readFile(String link) {
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        try {
            File file = new File(link);
            if (!file.exists()) {
                throw new Exception();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Facility facility;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                if (info.length == 10) {
                    facility = new Villa(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]), Integer.parseInt(info[3]),
                            info[4], info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8]));
                    Integer value = Integer.parseInt(info[9]);
                    facilityMap.put(facility, value);
                } else if (info.length == 9) {
                    facility = new House(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]), Integer.parseInt(info[3]),
                            info[4], info[5], info[6], Integer.parseInt(info[7]));
                    Integer value = Integer.parseInt(info[8]);
                    facilityMap.put(facility, value);
                } else if (info.length == 8) {
                    facility = new Room(info[0], Double.parseDouble(info[1]), Double.parseDouble(info[2]), Integer.parseInt(info[3]),
                            info[4], info[5], info[6]);
                    Integer value = Integer.parseInt(info[7]);
                    facilityMap.put(facility, value);
                }
            }
            bufferedReader.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return facilityMap;
    }

    public void writeFile(Map<Facility, Integer> facilityMap, String link) {
        try {
            File file = new File(link);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Set<Facility> facilitySet = facilityMap.keySet();
            for (Facility i : facilitySet) {
                bufferedWriter.write(getInfo(i) + "," + facilityMap.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
        }
    }

    private String getInfo(Facility i) {
        if (i instanceof Villa) {
            return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", i.getServiceName(), i.getUsableArea(), i.getRentalCosts(), i.getMaximumPeople()
                    , i.getRentalType(), i.getServiceCode(), ((Villa) i).getRoomStandard(), ((Villa) i).getPoolArea(), ((Villa) i).getNumberFloor());
        } else if (i instanceof House) {
            return String.format("%s,%s,%s,%s,%s,%s,%s,%s", i.getServiceName(), i.getUsableArea(), i.getRentalCosts(), i.getMaximumPeople()
                    , i.getRentalType(), i.getServiceCode(), ((House) i).getRoomStandard(), ((House) i).getNumberFloor());
        } else if (i instanceof Room) {
            return String.format("%s,%s,%s,%s,%s,%s,%s", i.getServiceName(), i.getUsableArea(), i.getRentalCosts(), i.getMaximumPeople()
                    , i.getRentalType(), i.getServiceCode(), ((Room) i).getFreeService());
        }
        return null;
    }


}






