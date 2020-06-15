
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Calendar;
import java.lang.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class JFrame extends javax.swing.JFrame {
    private static Timestamp timestamp; 
    private static ArrayList<Integer> semesterNumbers;
    private static Integer arrayLast;
    /**
     * Creates new form JFrame
     */
    public JFrame() {
        initComponents();
        categoryBox.setModel(new javax.swing.DefaultComboBoxModel(planning.getCategory().toArray()));
        courseBox.setModel(new javax.swing.DefaultComboBoxModel(course.getCourses().toArray()));
        
        DefaultTableModel memberTableModel = (DefaultTableModel)planTable1.getModel();
        ArrayList<ArrayList> getArray = planning.listPlanDue();
        Object[] tempObject = new Object[6];
        for(int i = 0; i < getArray.size(); i++){
            ArrayList tempMember = getArray.get(i);
            String title = (String)tempMember.get(0);
            String category = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due = (String)tempMember.get(3);
            String location = (String)tempMember.get(4);
            Integer mandatory = (Integer)tempMember.get(5);
            tempObject[0] = title;
            tempObject[1] = category;
            tempObject[2] = date;
            tempObject[3] = due;
            tempObject[4] = location;
            tempObject[5] = mandatory;
            memberTableModel.addRow(tempObject);
        }
        
        DefaultTableModel memberTableModel2 = (DefaultTableModel)planTable2.getModel();
        ArrayList<ArrayList> getArray2 = planning.listPlanCreate();
        Object[] tempObject2 = new Object[6];
        for(int i = 0; i < getArray2.size(); i++){
            ArrayList tempMember = getArray2.get(i);
            String title = (String)tempMember.get(0);
            String category = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due = (String)tempMember.get(3);
            String location = (String)tempMember.get(4);
            Integer mandatory = (Integer)tempMember.get(5);
            tempObject2[0] = title;
            tempObject2[1] = category;
            tempObject2[2] = date;
            tempObject2[3] = due;
            tempObject2[4] = location;
            tempObject2[5] = mandatory;
            memberTableModel2.addRow(tempObject2);
        }
        
        DefaultTableModel memberTableModel3 = (DefaultTableModel)planTable3.getModel();
        ArrayList<ArrayList> getArray3 = planning.listPlanMandatory();
        Object[] tempObject3 = new Object[6];
        for(int i = 0; i < getArray3.size(); i++){
            ArrayList tempMember = getArray3.get(i);
            String title = (String)tempMember.get(0);
            String category = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due = (String)tempMember.get(3);
            String location = (String)tempMember.get(4);
            Integer mandatory = (Integer)tempMember.get(5);
            tempObject3[0] = title;
            tempObject3[1] = category;
            tempObject3[2] = date;
            tempObject3[3] = due;
            tempObject3[4] = location;
            tempObject3[5] = mandatory;
            memberTableModel3.addRow(tempObject3);
        }
        
        DefaultTableModel memberTableModel4 = (DefaultTableModel)completeTable.getModel();
        ArrayList<ArrayList> getArray4 = planning.listCompleted();
        Object[] tempObject4 = new Object[6];
        for(int i = 0; i < getArray4.size(); i++){
            ArrayList tempMember = getArray4.get(i);
            String title = (String)tempMember.get(0);
            String category = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due = (String)tempMember.get(3);
            String location = (String)tempMember.get(4);
            Integer mandatory = (Integer)tempMember.get(5);
            tempObject4[0] = title;
            tempObject4[1] = category;
            tempObject4[2] = date;
            tempObject4[3] = due;
            tempObject4[4] = location;
            tempObject4[5] = mandatory;
            memberTableModel4.addRow(tempObject4);
        }
        
        semesterNumbers = course.getSemester();
        arrayLast = semesterNumbers.size()-1;
        Integer getSemesterInt = semesterNumbers.get(arrayLast);
        ArrayList<ArrayList> semesterGetTable = new ArrayList<ArrayList>();
        semesterGetTable = course.semesterTable(getSemesterInt);
        
        DefaultTableModel semesterTables = (DefaultTableModel)semesterTable.getModel();
        Object[] tempSemester = new Object[10];
        for(int i = 0; i < semesterGetTable.size(); i++){
            ArrayList tempSemesters = semesterGetTable.get(i);
            String cabbr = (String)tempSemesters.get(0);
            String cname = (String)tempSemesters.get(1);
            String croom = (String)tempSemesters.get(2);
            String prof = (String)tempSemesters.get(3);
            String poffice = (String)tempSemesters.get(4);
            String phour = (String)tempSemesters.get(5);
            String cdays = (String)tempSemesters.get(6);
            String ctime1 = (String)tempSemesters.get(7);
            String ctime2 = (String)tempSemesters.get(8);
            Integer clevel = (Integer)tempSemesters.get(9);
            tempSemester[0] = cabbr;
            tempSemester[1] = cname;
            tempSemester[2] = croom;
            tempSemester[3] = prof;
            tempSemester[4] = poffice;
            tempSemester[5] = phour;
            tempSemester[6] = cdays;
            tempSemester[7] = ctime1;
            tempSemester[8] = ctime2;
            tempSemester[9] = clevel;
            semesterTables.addRow(tempSemester);
        }
        semesterTextfield.setText("Semester: #" + getSemesterInt);
        
        ArrayList<ArrayList> tableList = new ArrayList<ArrayList>();
        tableList = note.noteTable();
        DefaultTableModel noteTableModel = (DefaultTableModel)noteTable.getModel();
        noteTableModel.setRowCount(0);
        Object[] tempListNote = new Object[4];
        for(int i = 0; i < tableList.size(); i++){
            ArrayList tempNote = tableList.get(i);
            String ntitleTemp = (String)tempNote.get(0);
            String createdTemp = (String)tempNote.get(1);
            String modifiedTemp = (String)tempNote.get(2);
            Integer NIDTemp = (Integer)tempNote.get(3);
            tempListNote[0] = ntitleTemp;
            tempListNote[1] = createdTemp;
            tempListNote[2] = modifiedTemp;
            tempListNote[3] = NIDTemp;
            noteTableModel.addRow(tempListNote);
        }
        timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        String strTimestamp = timestamp.toString();

        String part[] = strTimestamp.split(" ");
        String date = part[0];
        String splitDate[] = date.split("-");
        Integer theYear = Integer.parseInt(splitDate[0]);
        Integer theMonth = Integer.parseInt(splitDate[1]);
        Integer theDay = Integer.parseInt(splitDate[2]);
        Calendar calendar = new GregorianCalendar(theYear,theMonth,theDay,12,00,00);
        int whichDay  = calendar.get(Calendar.DAY_OF_WEEK);
        String getDay = "";
        if(whichDay == 6){
            getDay = "Wednesday";
        }
        if(whichDay == 7){
            getDay = "Thursday";
        }
        if(whichDay == 1){
            getDay = "Friday";
        }
        if(whichDay == 2){
            getDay = "Saturday";
        }
        if(whichDay == 3){
            getDay = "Sunday";
        }
        if(whichDay == 4){
            getDay = "Monday";
        }
        if(whichDay == 5){
            getDay = "Tuesday";
        }
        
        getTimeNowTextfield.setText(date + " " + getDay);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        getDateNow = new javax.swing.JPanel();
        getTimeNowTextfield = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        planTabbedPanel = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        planTabbedPane = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        planTable1 = new javax.swing.JTable();
        ViewButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        ViewButton2 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        planTable2 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        ViewButton3 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        planTable3 = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        ViewButton4 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        completeTable = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        viewDescTextfield = new javax.swing.JTextArea();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        completeButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        viewTitleTextfield = new javax.swing.JTextField();
        viewLocationTextfield = new javax.swing.JTextField();
        viewCreatedTextfield = new javax.swing.JTextField();
        viewDueTextfield = new javax.swing.JTextField();
        viewCategoryTextfield = new javax.swing.JTextField();
        viewPIDTextfield = new javax.swing.JTextField();
        viewMandatoryTextfield = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        viewStatusTextfield = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        planTitleTextfield = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        locationTextfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        planDescTextfield = new javax.swing.JTextArea();
        mandatorySlider = new javax.swing.JSlider();
        categoryBox = new javax.swing.JComboBox<>();
        categoryTextfield = new javax.swing.JTextField();
        sliderValue = new javax.swing.JLabel();
        createPlanButton = new javax.swing.JButton();
        addDateSpinner = new javax.swing.JSpinner();
        addPlanningOutput = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        courseTabbedPanel = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        semesterTable = new javax.swing.JTable();
        semesterTextfield = new javax.swing.JLabel();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        changeSemButton = new javax.swing.JButton();
        deleteSemButton = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        addAbbrTextfield = new javax.swing.JTextField();
        addNameTextfield = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        addPnameTextfield = new javax.swing.JTextField();
        addRoomTextfield = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        addPofficeTextfield = new javax.swing.JTextField();
        addPhourTextfield = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        monday = new javax.swing.JRadioButton();
        tuesday = new javax.swing.JRadioButton();
        wednesday = new javax.swing.JRadioButton();
        thursday = new javax.swing.JRadioButton();
        friday = new javax.swing.JRadioButton();
        saturday = new javax.swing.JRadioButton();
        online = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        courseBox = new javax.swing.JComboBox<>();
        hardnessSpinner = new javax.swing.JSpinner();
        removeClassButton = new javax.swing.JButton();
        addClassButton = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        semesterSpinner = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        classSpinner1 = new javax.swing.JSpinner();
        classSpinner2 = new javax.swing.JSpinner();
        jPanel17 = new javax.swing.JPanel();
        noteTabbedPane = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        noteTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        deleteNoteButton = new javax.swing.JButton();
        createNoteButton = new javax.swing.JButton();
        viewNoteButton = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        noteTitleTextfield = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        noteNoteTextfield = new javax.swing.JTextArea();
        modifyNoteButton = new javax.swing.JButton();
        deleteNoteButton2 = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        noteCreatedTextfield = new javax.swing.JTextField();
        noteModifiedTextfield = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        noteNIDTextfield = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("My Schedule Planner");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        getDateNow.setBackground(new java.awt.Color(255, 255, 255));

        getTimeNowTextfield.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getTimeNowTextfield.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout getDateNowLayout = new javax.swing.GroupLayout(getDateNow);
        getDateNow.setLayout(getDateNowLayout);
        getDateNowLayout.setHorizontalGroup(
            getDateNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(getTimeNowTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
        );
        getDateNowLayout.setVerticalGroup(
            getDateNowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(getTimeNowTextfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(getDateNow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(getDateNow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane1.setFocusCycleRoot(true);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        planTabbedPanel.setBackground(new java.awt.Color(204, 204, 255));
        planTabbedPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Plan List");

        planTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        planTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Category", "Created Date", "Due by", "Location", "Priority"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        planTable1.setRowHeight(30);
        planTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(planTable1);
        if (planTable1.getColumnModel().getColumnCount() > 0) {
            planTable1.getColumnModel().getColumn(0).setMinWidth(300);
            planTable1.getColumnModel().getColumn(0).setPreferredWidth(300);
            planTable1.getColumnModel().getColumn(0).setMaxWidth(300);
            planTable1.getColumnModel().getColumn(1).setMinWidth(200);
            planTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            planTable1.getColumnModel().getColumn(1).setMaxWidth(200);
            planTable1.getColumnModel().getColumn(2).setMinWidth(150);
            planTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            planTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            planTable1.getColumnModel().getColumn(3).setMinWidth(150);
            planTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            planTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            planTable1.getColumnModel().getColumn(4).setResizable(false);
            planTable1.getColumnModel().getColumn(4).setPreferredWidth(250);
            planTable1.getColumnModel().getColumn(5).setResizable(false);
            planTable1.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        ViewButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ViewButton1.setText("View");
        ViewButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(282, 282, 282)
                        .addComponent(ViewButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        planTabbedPane.addTab("Order by Due Date", jPanel7);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Plan List");

        ViewButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ViewButton2.setText("View");
        ViewButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButton2ActionPerformed(evt);
            }
        });

        planTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        planTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Category", "Created Date", "Due by", "Location", "Priority"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        planTable2.setRowHeight(30);
        planTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(planTable2);
        if (planTable2.getColumnModel().getColumnCount() > 0) {
            planTable2.getColumnModel().getColumn(0).setMinWidth(300);
            planTable2.getColumnModel().getColumn(0).setPreferredWidth(300);
            planTable2.getColumnModel().getColumn(0).setMaxWidth(300);
            planTable2.getColumnModel().getColumn(1).setMinWidth(200);
            planTable2.getColumnModel().getColumn(1).setPreferredWidth(200);
            planTable2.getColumnModel().getColumn(1).setMaxWidth(200);
            planTable2.getColumnModel().getColumn(2).setMinWidth(150);
            planTable2.getColumnModel().getColumn(2).setPreferredWidth(150);
            planTable2.getColumnModel().getColumn(2).setMaxWidth(150);
            planTable2.getColumnModel().getColumn(3).setMinWidth(150);
            planTable2.getColumnModel().getColumn(3).setPreferredWidth(150);
            planTable2.getColumnModel().getColumn(3).setMaxWidth(150);
            planTable2.getColumnModel().getColumn(4).setResizable(false);
            planTable2.getColumnModel().getColumn(4).setPreferredWidth(250);
            planTable2.getColumnModel().getColumn(5).setResizable(false);
            planTable2.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ViewButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        planTabbedPane.addTab("Order by Created Date", jPanel8);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Plan List");

        ViewButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ViewButton3.setText("View");
        ViewButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButton3ActionPerformed(evt);
            }
        });

        planTable3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        planTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Category", "Created Date", "Due by", "Location", "Priority"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        planTable3.setRowHeight(30);
        planTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(planTable3);
        if (planTable3.getColumnModel().getColumnCount() > 0) {
            planTable3.getColumnModel().getColumn(0).setMinWidth(300);
            planTable3.getColumnModel().getColumn(0).setPreferredWidth(300);
            planTable3.getColumnModel().getColumn(0).setMaxWidth(300);
            planTable3.getColumnModel().getColumn(1).setMinWidth(200);
            planTable3.getColumnModel().getColumn(1).setPreferredWidth(200);
            planTable3.getColumnModel().getColumn(1).setMaxWidth(200);
            planTable3.getColumnModel().getColumn(2).setMinWidth(150);
            planTable3.getColumnModel().getColumn(2).setPreferredWidth(150);
            planTable3.getColumnModel().getColumn(2).setMaxWidth(150);
            planTable3.getColumnModel().getColumn(3).setMinWidth(150);
            planTable3.getColumnModel().getColumn(3).setPreferredWidth(150);
            planTable3.getColumnModel().getColumn(3).setMaxWidth(150);
            planTable3.getColumnModel().getColumn(4).setResizable(false);
            planTable3.getColumnModel().getColumn(4).setPreferredWidth(250);
            planTable3.getColumnModel().getColumn(5).setResizable(false);
            planTable3.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(284, 284, 284)
                        .addComponent(ViewButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        planTabbedPane.addTab("Order by Mandatory", jPanel16);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Completed Plans");

        ViewButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ViewButton4.setText("View");
        ViewButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewButton4ActionPerformed(evt);
            }
        });

        completeTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        completeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Category", "Created Date", "Due by", "Location", "Priority"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        completeTable.setRowHeight(30);
        completeTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(completeTable);
        if (completeTable.getColumnModel().getColumnCount() > 0) {
            completeTable.getColumnModel().getColumn(0).setMinWidth(300);
            completeTable.getColumnModel().getColumn(0).setPreferredWidth(300);
            completeTable.getColumnModel().getColumn(0).setMaxWidth(300);
            completeTable.getColumnModel().getColumn(1).setMinWidth(200);
            completeTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            completeTable.getColumnModel().getColumn(1).setMaxWidth(200);
            completeTable.getColumnModel().getColumn(2).setMinWidth(150);
            completeTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            completeTable.getColumnModel().getColumn(2).setMaxWidth(150);
            completeTable.getColumnModel().getColumn(3).setMinWidth(150);
            completeTable.getColumnModel().getColumn(3).setPreferredWidth(150);
            completeTable.getColumnModel().getColumn(3).setMaxWidth(150);
            completeTable.getColumnModel().getColumn(4).setResizable(false);
            completeTable.getColumnModel().getColumn(4).setPreferredWidth(250);
            completeTable.getColumnModel().getColumn(5).setResizable(false);
            completeTable.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ViewButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ViewButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 619, Short.MAX_VALUE)
        );

        planTabbedPane.addTab("Completed Plans", jPanel21);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel36.setText("Title:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel37.setText("Description:");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel43.setText("Created:");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel44.setText("Categoty:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("View Plan");

        viewDescTextfield.setBackground(new java.awt.Color(204, 204, 255));
        viewDescTextfield.setColumns(20);
        viewDescTextfield.setRows(5);
        viewDescTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        viewDescTextfield.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane9.setViewportView(viewDescTextfield);

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel46.setText("Due:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel47.setText("Mandatory:");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel48.setText("Location:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel49.setText("PID:");

        completeButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        completeButton.setText("Complete");
        completeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButtonActionPerformed(evt);
            }
        });

        deleteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        modifyButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        viewTitleTextfield.setBackground(new java.awt.Color(204, 204, 255));
        viewTitleTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewTitleTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        viewLocationTextfield.setBackground(new java.awt.Color(204, 204, 255));
        viewLocationTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewLocationTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        viewCreatedTextfield.setEditable(false);
        viewCreatedTextfield.setBackground(new java.awt.Color(204, 204, 255));
        viewCreatedTextfield.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewCreatedTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        viewDueTextfield.setBackground(new java.awt.Color(204, 204, 255));
        viewDueTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewDueTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        viewDueTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDueTextfieldActionPerformed(evt);
            }
        });

        viewCategoryTextfield.setBackground(new java.awt.Color(204, 204, 255));
        viewCategoryTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewCategoryTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        viewPIDTextfield.setEditable(false);
        viewPIDTextfield.setBackground(new java.awt.Color(204, 204, 255));
        viewPIDTextfield.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewPIDTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        viewMandatoryTextfield.setBackground(new java.awt.Color(204, 204, 255));
        viewMandatoryTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewMandatoryTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel50.setText("Status:");

        viewStatusTextfield.setEditable(false);
        viewStatusTextfield.setBackground(new java.awt.Color(204, 204, 255));
        viewStatusTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewStatusTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(523, 523, 523))
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel36))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane9)
                            .addComponent(viewTitleTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewLocationTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(modifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(completeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel30Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viewCreatedTextfield))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                                        .addComponent(jLabel50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(viewStatusTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel30Layout.createSequentialGroup()
                                            .addComponent(jLabel44)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(viewCategoryTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel30Layout.createSequentialGroup()
                                                .addComponent(jLabel49)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(viewPIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel47)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(viewMandatoryTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel30Layout.createSequentialGroup()
                                                .addComponent(jLabel46)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(viewDueTextfield)))))))
                        .addGap(4, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viewCreatedTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(viewTitleTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewLocationTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(304, 304, 304))))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(viewPIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel47)
                            .addComponent(viewMandatoryTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewDueTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(viewCategoryTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(viewStatusTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(completeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        planTabbedPane.addTab("View Plan", jPanel25);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(planTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(planTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );

        planTabbedPanel.addTab("List", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Create Plan");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel22.setText("Plan Title:");

        planTitleTextfield.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        planTitleTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planTitleTextfieldActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel23.setText("Plan Description:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel24.setText("Plan Due Date:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel25.setText("Mandatory:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel26.setText("Plan Location:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel27.setText("Plan Category:");

        locationTextfield.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        locationTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locationTextfieldActionPerformed(evt);
            }
        });

        planDescTextfield.setColumns(20);
        planDescTextfield.setRows(5);
        jScrollPane1.setViewportView(planDescTextfield);

        mandatorySlider.setMaximum(10);
        mandatorySlider.setMinimum(1);
        mandatorySlider.setValue(5);
        mandatorySlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                mandatorySliderStateChanged(evt);
            }
        });

        categoryBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        categoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Or new category->" }));

        categoryTextfield.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        categoryTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryTextfieldActionPerformed(evt);
            }
        });

        sliderValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sliderValue.setText("5");

        createPlanButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        createPlanButton.setText("Create Plan");
        createPlanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlanButtonActionPerformed(evt);
            }
        });

        addDateSpinner.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addDateSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(946702800000L), null, java.util.Calendar.DAY_OF_WEEK_IN_MONTH));
        addDateSpinner.setEditor(new javax.swing.JSpinner.DateEditor(addDateSpinner, "yyyy/MM/dd hh:mm a"));

        addPlanningOutput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(addPlanningOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createPlanButton)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(categoryTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 691, Short.MAX_VALUE))
                                    .addComponent(locationTextfield)))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(mandatorySlider, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sliderValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(planTitleTextfield)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1046, Short.MAX_VALUE))))
                .addGap(152, 152, 152))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(442, 442, 442)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(planTitleTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(addDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(6, 6, 6))
                            .addComponent(sliderValue)))
                    .addComponent(mandatorySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locationTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createPlanButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addPlanningOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 156, Short.MAX_VALUE))
        );

        planTabbedPanel.addTab("Create", jPanel10);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(planTabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(planTabbedPanel)
        );

        jTabbedPane1.addTab("Plan", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        courseTabbedPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        semesterTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        semesterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Class Abbre", "Class name", "Classroom", "Professor", "Office Location", "Office Hour", "Days", "Class Starts", "Class Ends", "Level(1-10)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        semesterTable.setRowHeight(30);
        semesterTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(semesterTable);
        if (semesterTable.getColumnModel().getColumnCount() > 0) {
            semesterTable.getColumnModel().getColumn(0).setResizable(false);
            semesterTable.getColumnModel().getColumn(1).setResizable(false);
            semesterTable.getColumnModel().getColumn(2).setResizable(false);
            semesterTable.getColumnModel().getColumn(3).setResizable(false);
            semesterTable.getColumnModel().getColumn(4).setResizable(false);
            semesterTable.getColumnModel().getColumn(5).setResizable(false);
            semesterTable.getColumnModel().getColumn(6).setResizable(false);
            semesterTable.getColumnModel().getColumn(7).setResizable(false);
            semesterTable.getColumnModel().getColumn(8).setResizable(false);
            semesterTable.getColumnModel().getColumn(9).setResizable(false);
        }

        semesterTextfield.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        semesterTextfield.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        semesterTextfield.setText("Semester: #1");

        prevButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prevButton.setText("Prev semester");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nextButton.setText("Next semester");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        changeSemButton.setText("Change");
        changeSemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeSemButtonActionPerformed(evt);
            }
        });

        deleteSemButton.setText("Delete");
        deleteSemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prevButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(semesterTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(changeSemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteSemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nextButton)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1182, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(prevButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(semesterTextfield, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(changeSemButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteSemButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
        );

        courseTabbedPanel.addTab("Table mode", jPanel12);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Remove Class");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Class Abbreviation:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Class Name:");

        addAbbrTextfield.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addAbbrTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAbbrTextfieldActionPerformed(evt);
            }
        });

        addNameTextfield.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addNameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNameTextfieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Professor Name:");

        addPnameTextfield.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addPnameTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPnameTextfieldActionPerformed(evt);
            }
        });

        addRoomTextfield.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addRoomTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomTextfieldActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Professor Office:");

        addPofficeTextfield.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addPofficeTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPofficeTextfieldActionPerformed(evt);
            }
        });

        addPhourTextfield.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addPhourTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPhourTextfieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("Professor Hours:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Classroom:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setText("Days:");

        monday.setBackground(new java.awt.Color(255, 255, 255));
        monday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        monday.setText("Monday");

        tuesday.setBackground(new java.awt.Color(255, 255, 255));
        tuesday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tuesday.setText("Tuesday");

        wednesday.setBackground(new java.awt.Color(255, 255, 255));
        wednesday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wednesday.setText("Wednesday");
        wednesday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesdayActionPerformed(evt);
            }
        });

        thursday.setBackground(new java.awt.Color(255, 255, 255));
        thursday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        thursday.setText("Thursday");

        friday.setBackground(new java.awt.Color(255, 255, 255));
        friday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        friday.setText("Friday");

        saturday.setBackground(new java.awt.Color(255, 255, 255));
        saturday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        saturday.setText("Saturday");
        saturday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturdayActionPerformed(evt);
            }
        });

        online.setBackground(new java.awt.Color(255, 255, 255));
        online.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        online.setText("Online");
        online.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onlineActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setText("Time:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setText("Level of Hardness:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setText("(From 1 to 10)");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Add Class");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel18.setText("Class Abbreviation:");

        courseBox.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        hardnessSpinner.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        hardnessSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        removeClassButton.setBackground(new java.awt.Color(204, 204, 255));
        removeClassButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        removeClassButton.setText("Remove Class");
        removeClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeClassButtonActionPerformed(evt);
            }
        });

        addClassButton.setBackground(new java.awt.Color(204, 204, 255));
        addClassButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addClassButton.setText("Add Class");
        addClassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassButtonActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel32.setText("Semester:");

        semesterSpinner.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        semesterSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 16, 1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setText("~");

        classSpinner1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        classSpinner1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1591459200000L), null, null, java.util.Calendar.AM_PM));
        classSpinner1.setEditor(new javax.swing.JSpinner.DateEditor(classSpinner1, "hh:mm a"));

        classSpinner2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        classSpinner2.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1591459200000L), null, null, java.util.Calendar.AM_PM));
        classSpinner2.setEditor(new javax.swing.JSpinner.DateEditor(classSpinner2, "hh:mm a"));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addAbbrTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addPnameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addRoomTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addPhourTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addPofficeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(monday)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tuesday)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(wednesday))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(thursday)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(friday)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(saturday)
                                        .addGap(3, 3, 3)
                                        .addComponent(online))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(classSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(classSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(addClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(hardnessSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(semesterSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(448, 448, 448)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabel18)
                                .addGap(27, 27, 27)
                                .addComponent(courseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(573, 573, 573)
                        .addComponent(removeClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(30, 30, 30)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(addAbbrTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(monday)
                            .addComponent(tuesday)
                            .addComponent(wednesday))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(addNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thursday)
                            .addComponent(friday)
                            .addComponent(saturday)
                            .addComponent(online)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(hardnessSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRoomTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(classSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel32)
                    .addComponent(semesterSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPnameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(addPofficeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(addPhourTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(addClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(courseBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(removeClassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        courseTabbedPanel.addTab("Modify class", jPanel15);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(courseTabbedPanel)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(courseTabbedPanel)
        );

        jTabbedPane1.addTab("Class", jPanel6);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        noteTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
        noteTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        noteTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Created", "Modified", "Note ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        noteTable.setRowHeight(24);
        noteTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(noteTable);
        if (noteTable.getColumnModel().getColumnCount() > 0) {
            noteTable.getColumnModel().getColumn(0).setMinWidth(700);
            noteTable.getColumnModel().getColumn(0).setPreferredWidth(700);
            noteTable.getColumnModel().getColumn(0).setMaxWidth(700);
            noteTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            noteTable.getColumnModel().getColumn(2).setResizable(false);
            noteTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            noteTable.getColumnModel().getColumn(3).setMinWidth(100);
            noteTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            noteTable.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Note");

        deleteNoteButton.setText("Delete");
        deleteNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNoteButtonActionPerformed(evt);
            }
        });

        createNoteButton.setText("Create");
        createNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNoteButtonActionPerformed(evt);
            }
        });

        viewNoteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewNoteButton.setText("View");
        viewNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewNoteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(428, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(viewNoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteNoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createNoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jScrollPane4)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(viewNoteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createSequentialGroup()
                            .addComponent(createNoteButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteNoteButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );

        noteTabbedPane.addTab("List", jPanel19);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("View Note");

        noteTitleTextfield.setBackground(new java.awt.Color(204, 204, 255));
        noteTitleTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noteTitleTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        noteNoteTextfield.setBackground(new java.awt.Color(204, 204, 255));
        noteNoteTextfield.setColumns(20);
        noteNoteTextfield.setRows(5);
        noteNoteTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        noteNoteTextfield.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane10.setViewportView(noteNoteTextfield);

        modifyNoteButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modifyNoteButton.setText("Modify");
        modifyNoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyNoteButtonActionPerformed(evt);
            }
        });

        deleteNoteButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteNoteButton2.setText("Delete");
        deleteNoteButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNoteButton2ActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel38.setText("Title:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel39.setText("Note:");

        noteCreatedTextfield.setEditable(false);
        noteCreatedTextfield.setBackground(new java.awt.Color(204, 204, 255));
        noteCreatedTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noteCreatedTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        noteModifiedTextfield.setEditable(false);
        noteModifiedTextfield.setBackground(new java.awt.Color(204, 204, 255));
        noteModifiedTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noteModifiedTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel40.setText("Modified:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel41.setText("Created:");

        noteNIDTextfield.setEditable(false);
        noteNIDTextfield.setBackground(new java.awt.Color(204, 204, 255));
        noteNIDTextfield.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        noteNIDTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel42.setText("Note ID:");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel38)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(noteNIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(152, 152, 152)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 342, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noteCreatedTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noteModifiedTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(modifyNoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteNoteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(noteTitleTextfield)
                    .addComponent(jScrollPane10))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(noteNIDTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel42)))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(noteTitleTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(modifyNoteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deleteNoteButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel41)
                                    .addComponent(noteCreatedTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(noteModifiedTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel39)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        noteTabbedPane.addTab("Read", jPanel20);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(noteTabbedPane)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(noteTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Note", jPanel17);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("before" + arrayLast);
        System.out.println(semesterNumbers.size() - 1);
        
        try{
            arrayLast = arrayLast + 1;
            System.out.println("after" + arrayLast);
            Integer getSemesterInt = semesterNumbers.get(arrayLast);
            ArrayList<ArrayList> semesterGetTable = new ArrayList<ArrayList>();
            semesterGetTable = course.semesterTable(getSemesterInt);
            DefaultTableModel semesterTables = (DefaultTableModel)semesterTable.getModel();
            semesterTables.setRowCount(0);
            Object[] tempSemester = new Object[10];
            for(int i = 0; i < semesterGetTable.size(); i++){
                ArrayList tempSemesters = semesterGetTable.get(i);
                String cabbr = (String)tempSemesters.get(0);
                String cname = (String)tempSemesters.get(1);
                String croom = (String)tempSemesters.get(2);
                String prof = (String)tempSemesters.get(3);
                String poffice1 = (String)tempSemesters.get(4);
                String phour1 = (String)tempSemesters.get(5);
                String cdays = (String)tempSemesters.get(6);
                String ctime1 = (String)tempSemesters.get(7);
                String ctime2 = (String)tempSemesters.get(8);
                Integer clevel = (Integer)tempSemesters.get(9);
                tempSemester[0] = cabbr;
                tempSemester[1] = cname;
                tempSemester[2] = croom;
                tempSemester[3] = prof;
                tempSemester[4] = poffice1;
                tempSemester[5] = phour1;
                tempSemester[6] = cdays;
                tempSemester[7] = ctime1;
                tempSemester[8] = ctime2;
                tempSemester[9] = clevel;
                semesterTables.addRow(tempSemester);
            }
            semesterTextfield.setText("Semester: #" + getSemesterInt);
        } 
        catch(Exception ex){
            error.getMessage("There is no next semester!");
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    private void createPlanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlanButtonActionPerformed
        // TODO add your handling code here:

        
        
        String title = (String) planTitleTextfield.getText();
        String desc = (String) planDescTextfield.getText();
        String location = (String) locationTextfield.getText();
        int value = mandatorySlider.getValue();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
        String spinnerString = dateFormat.format(addDateSpinner.getValue());
        String part[]= spinnerString.split(" ");

        String getCategory;
        String category = (String) categoryBox.getSelectedItem();
        if (category == "Or new category->"){
            getCategory = (String) categoryTextfield.getText();
        }
        else{
            getCategory = category;
        }
        
        timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        String strTimestamp = timestamp.toString();

        String part2[] = strTimestamp.split(" ");
        String datePart[] = part2[0].split("-");
        String timePart[] = part2[1].split(":");
        Integer hourInt = Integer.parseInt(timePart[0]);
        String getTimestamp = "";

        if (hourInt == 0){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1] + " " + "AM";
        }
        else if (hourInt > 0 && hourInt < 10){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 0" + timePart[0] + ":" + timePart[1] + " " + "AM";
        }
        else if (hourInt >= 10 && hourInt < 12){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1] + " " + "AM";
        }
        else if (hourInt == 12){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1] + " " + "PM";
        }
        else if (hourInt > 12 && hourInt < 22){
            Integer hourMinus12 = hourInt - 12;
            String hourStr = Integer.toString(hourMinus12);
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 0" + hourStr + ":" + timePart[1] + " " + "PM";
        }
        else if(hourInt >= 22 && hourInt < 24){
            Integer hourMinus12 = hourInt - 12;
            String hourStr = Integer.toString(hourMinus12);
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + hourStr + ":" + timePart[1] + " " + "PM";
        }

        String getTimestamp24 = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1];

        String spinnerString24 = "";
        String part3[] = spinnerString.split(" ");
        String datePart2[] = part3[0].split("/");
        String timePart2[] = part3[1].split(":");
        Integer hourInt2 = Integer.parseInt(timePart2[0]);

        String tempm = (String) part3[2];
        String am = "AM";
        String pm = "PM";

        Integer compareAM = tempm.compareTo(am);
        Integer comparePM = tempm.compareTo(pm);

        if (compareAM == 0 && comparePM != 0){
            if (hourInt2 >= 1 && hourInt2 <= 11){
                spinnerString24 = datePart2[0] + "/" + datePart2[1] + "/" + datePart2[2] + " " + timePart2[0] + ":" + timePart2[1];
            }
            else if (hourInt2 == 12){
                spinnerString24 = datePart2[0] + "/" + datePart2[1] + "/" + datePart2[2] + " 00:" + timePart2[1];
            }
        }
        else if(comparePM == 0 && compareAM != 0){
            if (hourInt2 >= 1 && hourInt2 <= 11){
                Integer hourInt3 = hourInt2 + 12;
                String hourStr = Integer.toString(hourInt3);
                spinnerString24 = datePart2[0] + "/" + datePart2[1] + "/" + datePart2[2] + " " + hourStr + ":" + timePart2[1];
            }
            else if (hourInt2 == 12){
                Integer hourInt3 = hourInt2 + 12;
                String hourStr = Integer.toString(hourInt3);
                spinnerString24 = datePart2[0] + "/" + datePart2[1] + "/" + datePart2[2] + " 12:" + timePart2[1];
            }
        }

        Integer tempCompare = spinnerString24.compareTo(getTimestamp24);

        int yearInt = Integer.parseInt(datePart2[0]);
        int monthInt = Integer.parseInt(datePart2[1]);
        int dayInt = Integer.parseInt(datePart2[2]);

        addPlanningOutput.setText("");

        if(title.compareTo("") == 0){
            error.getMessage("Please enter the title!");
        }
        else if (desc.compareTo("") == 0){
            error.getMessage("Please enter the description!");
        }
        else if (tempCompare < 0){
            error.getMessage("Please enter the future date!");
        }
        else if (category.compareTo("Or new category->") == 0 && getCategory.compareTo("") == 0){
            error.getMessage("Please enter the category!");
        }
        else if (title.compareTo("") != 0){
            planning.addPlanning(title, getTimestamp24, desc, spinnerString24, getCategory, location, value);
            categoryBox.setModel(new javax.swing.DefaultComboBoxModel(planning.getCategory().toArray()));

            DefaultTableModel memberTableModel = (DefaultTableModel)planTable1.getModel();
            DefaultTableModel memberTableModel2 = (DefaultTableModel)planTable2.getModel();
            DefaultTableModel memberTableModel3 = (DefaultTableModel)planTable3.getModel();
            DefaultTableModel memberTableModel4 = (DefaultTableModel)completeTable.getModel();

            memberTableModel.setRowCount(0);
            memberTableModel2.setRowCount(0);
            memberTableModel3.setRowCount(0);
            memberTableModel4.setRowCount(0);

            ArrayList<ArrayList> getArray = planning.listPlanDue();
            Object[] tempObject = new Object[6];
            for(int i = 0; i < getArray.size(); i++){
                ArrayList tempMember = getArray.get(i);
                String title1 = (String)tempMember.get(0);
                String category1 = (String)tempMember.get(1);
                String date = (String)tempMember.get(2);
                String due = (String)tempMember.get(3);
                String location1 = (String)tempMember.get(4);
                Integer mandatory = (Integer)tempMember.get(5);
                tempObject[0] = title1;
                tempObject[1] = category1;
                tempObject[2] = date;
                tempObject[3] = due;
                tempObject[4] = location1;
                tempObject[5] = mandatory;
                memberTableModel.addRow(tempObject);
            }

            ArrayList<ArrayList> getArray2 = planning.listPlanCreate();
            Object[] tempObject2 = new Object[6];
            for(int i = 0; i < getArray2.size(); i++){
                ArrayList tempMember = getArray2.get(i);
                String title1 = (String)tempMember.get(0);
                String category1 = (String)tempMember.get(1);
                String date = (String)tempMember.get(2);
                String due = (String)tempMember.get(3);
                String location1 = (String)tempMember.get(4);
                Integer mandatory = (Integer)tempMember.get(5);
                tempObject2[0] = title1;
                tempObject2[1] = category1;
                tempObject2[2] = date;
                tempObject2[3] = due;
                tempObject2[4] = location1;
                tempObject2[5] = mandatory;
                memberTableModel2.addRow(tempObject2);
            }

            ArrayList<ArrayList> getArray3 = planning.listPlanMandatory();
            Object[] tempObject3 = new Object[6];
            for(int i = 0; i < getArray3.size(); i++){
                ArrayList tempMember = getArray3.get(i);
                String title1 = (String)tempMember.get(0);
                String category1 = (String)tempMember.get(1);
                String date = (String)tempMember.get(2);
                String due = (String)tempMember.get(3);
                String location1 = (String)tempMember.get(4);
                Integer mandatory = (Integer)tempMember.get(5);
                tempObject3[0] = title1;
                tempObject3[1] = category1;
                tempObject3[2] = date;
                tempObject3[3] = due;
                tempObject3[4] = location1;
                tempObject3[5] = mandatory;
                memberTableModel3.addRow(tempObject3);
            }

            ArrayList<ArrayList> getArray4 = planning.listCompleted();
            Object[] tempObject4 = new Object[6];
            for(int i = 0; i < getArray4.size(); i++){
                ArrayList tempMember = getArray4.get(i);
                String title1 = (String)tempMember.get(0);
                String category1 = (String)tempMember.get(1);
                String date = (String)tempMember.get(2);
                String due = (String)tempMember.get(3);
                String location1 = (String)tempMember.get(4);
                Integer mandatory = (Integer)tempMember.get(5);
                tempObject4[0] = title1;
                tempObject4[1] = category1;
                tempObject4[2] = date;
                tempObject4[3] = due;
                tempObject4[4] = location1;
                tempObject4[5] = mandatory;
                memberTableModel4.addRow(tempObject4);
            }
            planTabbedPane.setSelectedIndex(0);
            planTabbedPanel.setSelectedIndex(0);
        }
    }//GEN-LAST:event_createPlanButtonActionPerformed

    private void categoryTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryTextfieldActionPerformed

    private void mandatorySliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_mandatorySliderStateChanged
        // TODO add your handling code here:
        int value = mandatorySlider.getValue();
        sliderValue.setText(value + " ");
    }//GEN-LAST:event_mandatorySliderStateChanged

    private void locationTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locationTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_locationTextfieldActionPerformed

    private void planTitleTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planTitleTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_planTitleTextfieldActionPerformed

    private void ViewButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButton4ActionPerformed
        // TODO add your handling code here:
        try{
            int column = 0;
            int row = completeTable.getSelectedRow();
            String title = completeTable.getModel().getValueAt(row, 0).toString();
            String category = completeTable.getModel().getValueAt(row, 1).toString();
            String date = completeTable.getModel().getValueAt(row, 2).toString();
            String due = completeTable.getModel().getValueAt(row, 3).toString();
            String location = completeTable.getModel().getValueAt(row, 4).toString();
            String mandatory = completeTable.getModel().getValueAt(row, 5).toString();
            Integer intMan = Integer.parseInt(mandatory);
            ArrayList getInfo = new ArrayList();
            getInfo = planning.view(title, category, date, due, location, intMan);
            String ArrayTitle = (String)getInfo.get(0);
            String ArrayCategory = (String)getInfo.get(1);
            String ArrayCreated = (String)getInfo.get(2);
            String ArrayDue = (String)getInfo.get(3);
            String ArrayLocation = (String)getInfo.get(4);
            Integer ArrayMandatory = (Integer)getInfo.get(5);
            String ArrayDesc = (String)getInfo.get(6);
            Boolean ArrayComplete = (Boolean)getInfo.get(7);
            Integer ArrayPID = (Integer)getInfo.get(8);
            String stringMandatory = Integer.toString(ArrayMandatory);
            String stringPID = Integer.toString(ArrayPID);

            viewTitleTextfield.setText(ArrayTitle);
            viewDescTextfield.setText(ArrayDesc);
            viewLocationTextfield.setText(ArrayLocation);
            viewCreatedTextfield.setText(ArrayCreated);
            viewDueTextfield.setText(ArrayDue);
            viewCategoryTextfield.setText(ArrayCategory);
            viewMandatoryTextfield.setText(stringMandatory);
            viewPIDTextfield.setText(stringPID);
            planTabbedPane.setSelectedIndex(4);

            String status = "";
            if (ArrayComplete == true){
                status = "Completed";
                completeButton.setText("Mark Incomplete");
            }
            else{
                status = "Incomplete";
                completeButton.setText("Mark Complete");
            }
            viewStatusTextfield.setText(status);
        }
        catch(Exception e){
            error.getMessage("Please select the plan!");
        }
    }//GEN-LAST:event_ViewButton4ActionPerformed

    private void ViewButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButton3ActionPerformed
        // TODO add your handling code here:
        try{
            int column = 0;
            int row = planTable3.getSelectedRow();
            String title = planTable3.getModel().getValueAt(row, 0).toString();
            String category = planTable3.getModel().getValueAt(row, 1).toString();
            String date = planTable3.getModel().getValueAt(row, 2).toString();
            String due = planTable3.getModel().getValueAt(row, 3).toString();
            String location = planTable3.getModel().getValueAt(row, 4).toString();
            String mandatory = planTable3.getModel().getValueAt(row, 5).toString();
            Integer intMan = Integer.parseInt(mandatory);
            ArrayList getInfo = new ArrayList();
            getInfo = planning.view(title, category, date, due, location, intMan);
            String ArrayTitle = (String)getInfo.get(0);
            String ArrayCategory = (String)getInfo.get(1);
            String ArrayCreated = (String)getInfo.get(2);
            String ArrayDue = (String)getInfo.get(3);
            String ArrayLocation = (String)getInfo.get(4);
            Integer ArrayMandatory = (Integer)getInfo.get(5);
            String ArrayDesc = (String)getInfo.get(6);
            Boolean ArrayComplete = (Boolean)getInfo.get(7);
            Integer ArrayPID = (Integer)getInfo.get(8);
            String stringMandatory = Integer.toString(ArrayMandatory);
            String stringPID = Integer.toString(ArrayPID);

            viewTitleTextfield.setText(ArrayTitle);
            viewDescTextfield.setText(ArrayDesc);
            viewLocationTextfield.setText(ArrayLocation);
            viewCreatedTextfield.setText(ArrayCreated);
            viewDueTextfield.setText(ArrayDue);
            viewCategoryTextfield.setText(ArrayCategory);
            viewMandatoryTextfield.setText(stringMandatory);
            viewPIDTextfield.setText(stringPID);
            planTabbedPane.setSelectedIndex(4);

            String status = "";
            if (ArrayComplete == true){
                status = "Completed";
                completeButton.setText("Mark Incomplete");
            }
            else{
                status = "Incomplete";
                completeButton.setText("Mark Complete");
            }
            viewStatusTextfield.setText(status);
        }
        catch(Exception e){
            error.getMessage("Please select the plan!");
        }
    }//GEN-LAST:event_ViewButton3ActionPerformed

    private void ViewButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButton2ActionPerformed
        // TODO add your handling code here:
        try{
            int column = 0;
            int row = planTable2.getSelectedRow();
            String title = planTable2.getModel().getValueAt(row, 0).toString();
            String category = planTable2.getModel().getValueAt(row, 1).toString();
            String date = planTable2.getModel().getValueAt(row, 2).toString();
            String due = planTable2.getModel().getValueAt(row, 3).toString();
            String location = planTable2.getModel().getValueAt(row, 4).toString();
            String mandatory = planTable2.getModel().getValueAt(row, 5).toString();
            Integer intMan = Integer.parseInt(mandatory);
            ArrayList getInfo = new ArrayList();
            getInfo = planning.view(title, category, date, due, location, intMan);
            String ArrayTitle = (String)getInfo.get(0);
            String ArrayCategory = (String)getInfo.get(1);
            String ArrayCreated = (String)getInfo.get(2);
            String ArrayDue = (String)getInfo.get(3);
            String ArrayLocation = (String)getInfo.get(4);
            Integer ArrayMandatory = (Integer)getInfo.get(5);
            String ArrayDesc = (String)getInfo.get(6);
            Boolean ArrayComplete = (Boolean)getInfo.get(7);
            Integer ArrayPID = (Integer)getInfo.get(8);
            String stringMandatory = Integer.toString(ArrayMandatory);
            String stringPID = Integer.toString(ArrayPID);

            viewTitleTextfield.setText(ArrayTitle);
            viewDescTextfield.setText(ArrayDesc);
            viewLocationTextfield.setText(ArrayLocation);
            viewCreatedTextfield.setText(ArrayCreated);
            viewDueTextfield.setText(ArrayDue);
            viewCategoryTextfield.setText(ArrayCategory);
            viewMandatoryTextfield.setText(stringMandatory);
            viewPIDTextfield.setText(stringPID);
            planTabbedPane.setSelectedIndex(4);
            
            String status = "";
            if (ArrayComplete == true){
                status = "Completed";
                completeButton.setText("Mark Incomplete");
            }
            else{
                status = "Incomplete";
                completeButton.setText("Mark Complete");
            }
            viewStatusTextfield.setText(status);
        }
        catch(Exception e){
            error.getMessage("Please select the plan!");
        }
    }//GEN-LAST:event_ViewButton2ActionPerformed

    private void ViewButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewButton1ActionPerformed
        // TODO add your handling code here:
        try{
            int column = 0;
            int row = planTable1.getSelectedRow();
            String title = planTable1.getModel().getValueAt(row, 0).toString();
            String category = planTable1.getModel().getValueAt(row, 1).toString();
            String date = planTable1.getModel().getValueAt(row, 2).toString();
            String due = planTable1.getModel().getValueAt(row, 3).toString();
            String location = planTable1.getModel().getValueAt(row, 4).toString();
            String mandatory = planTable1.getModel().getValueAt(row, 5).toString();
            Integer intMan = Integer.parseInt(mandatory);
            ArrayList getInfo = new ArrayList();
            getInfo = planning.view(title, category, date, due, location, intMan);
            String ArrayTitle = (String)getInfo.get(0);
            String ArrayCategory = (String)getInfo.get(1);
            String ArrayCreated = (String)getInfo.get(2);
            String ArrayDue = (String)getInfo.get(3);
            String ArrayLocation = (String)getInfo.get(4);
            Integer ArrayMandatory = (Integer)getInfo.get(5);
            String ArrayDesc = (String)getInfo.get(6);
            Boolean ArrayComplete = (Boolean)getInfo.get(7);
            Integer ArrayPID = (Integer)getInfo.get(8);
            String stringMandatory = Integer.toString(ArrayMandatory);
            String stringPID = Integer.toString(ArrayPID);

            viewTitleTextfield.setText(ArrayTitle);
            viewDescTextfield.setText(ArrayDesc);
            viewLocationTextfield.setText(ArrayLocation);
            viewCreatedTextfield.setText(ArrayCreated);
            viewDueTextfield.setText(ArrayDue);
            viewCategoryTextfield.setText(ArrayCategory);
            viewMandatoryTextfield.setText(stringMandatory);
            viewPIDTextfield.setText(stringPID);
            planTabbedPane.setSelectedIndex(4);
            String status = "";
            if (ArrayComplete == true){
                status = "Completed";
                completeButton.setText("Mark Incomplete");
            }
            else{
                status = "Incomplete";
                completeButton.setText("Mark Complete");
            }
            viewStatusTextfield.setText(status);
        }
        catch(Exception e){
            error.getMessage("Please select the plan!");
        }
    }//GEN-LAST:event_ViewButton1ActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        // TODO add your handling code here:
        
        String getPid = (String)viewPIDTextfield.getText();
        Integer PID = Integer.parseInt(getPid);
        String getMandatory = (String)viewMandatoryTextfield.getText();
        Integer mandatory = Integer.parseInt(getMandatory);
        
        String title = (String) viewTitleTextfield.getText();
        String desc = (String) viewDescTextfield.getText();
        String location = (String) viewLocationTextfield.getText();
        String category = (String) viewCategoryTextfield.getText();
        String due = (String) viewDueTextfield.getText();
        
        planning.modifyingPlan(title, desc, location, category, mandatory, PID, due);
        
        categoryBox.setModel(new javax.swing.DefaultComboBoxModel(planning.getCategory().toArray()));

        DefaultTableModel memberTableModel = (DefaultTableModel)planTable1.getModel();
        DefaultTableModel memberTableModel2 = (DefaultTableModel)planTable2.getModel();
        DefaultTableModel memberTableModel3 = (DefaultTableModel)planTable3.getModel();
        DefaultTableModel memberTableModel4 = (DefaultTableModel)completeTable.getModel();

        memberTableModel.setRowCount(0);
        memberTableModel2.setRowCount(0);
        memberTableModel3.setRowCount(0);
        memberTableModel4.setRowCount(0);

        ArrayList<ArrayList> getArray = planning.listPlanDue();
        Object[] tempObject = new Object[6];
        for(int i = 0; i < getArray.size(); i++){
            ArrayList tempMember = getArray.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
            tempObject[0] = title1;
            tempObject[1] = category1;
            tempObject[2] = date;
            tempObject[3] = due1;
            tempObject[4] = location1;
            tempObject[5] = mandatory1;
            memberTableModel.addRow(tempObject);
        }

        ArrayList<ArrayList> getArray2 = planning.listPlanCreate();
        Object[] tempObject2 = new Object[6];
        for(int i = 0; i < getArray2.size(); i++){
            ArrayList tempMember = getArray2.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
            tempObject2[0] = title1;
            tempObject2[1] = category1;
            tempObject2[2] = date;
            tempObject2[3] = due1;
            tempObject2[4] = location1;
            tempObject2[5] = mandatory1;
            memberTableModel2.addRow(tempObject2);
        }

        ArrayList<ArrayList> getArray3 = planning.listPlanMandatory();
        Object[] tempObject3 = new Object[6];
        for(int i = 0; i < getArray3.size(); i++){
            ArrayList tempMember = getArray3.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
                tempObject3[0] = title1;
                tempObject3[1] = category1;
                tempObject3[2] = date;
                tempObject3[3] = due1;
                tempObject3[4] = location1;
                tempObject3[5] = mandatory1;
                memberTableModel3.addRow(tempObject3);
            }

        ArrayList<ArrayList> getArray4 = planning.listCompleted();
        Object[] tempObject4 = new Object[6];
        for(int i = 0; i < getArray4.size(); i++){
            ArrayList tempMember = getArray4.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
            tempObject4[0] = title1;
            tempObject4[1] = category1;
            tempObject4[2] = date;
            tempObject4[3] = due1;
            tempObject4[4] = location1;
            tempObject4[5] = mandatory1;
            memberTableModel4.addRow(tempObject4);
        }
        
        viewTitleTextfield.setText("");
        viewDescTextfield.setText("");
        viewLocationTextfield.setText("");
        viewCreatedTextfield.setText("");
        viewDueTextfield.setText("");
        viewCategoryTextfield.setText("");
        viewMandatoryTextfield.setText("");
        viewPIDTextfield.setText("");
        viewStatusTextfield.setText("");
        completeButton.setText("Complete");
        
        planTabbedPane.setSelectedIndex(0);
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void viewDueTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDueTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewDueTextfieldActionPerformed

    private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeButtonActionPerformed
        // TODO add your handling code here:
        String getPid = (String)viewPIDTextfield.getText();
        Integer PID = Integer.parseInt(getPid);
        
        planning.completePlan(PID);
        
        DefaultTableModel memberTableModel = (DefaultTableModel)planTable1.getModel();
        DefaultTableModel memberTableModel2 = (DefaultTableModel)planTable2.getModel();
        DefaultTableModel memberTableModel3 = (DefaultTableModel)planTable3.getModel();
        DefaultTableModel memberTableModel4 = (DefaultTableModel)completeTable.getModel();

        memberTableModel.setRowCount(0);
        memberTableModel2.setRowCount(0);
        memberTableModel3.setRowCount(0);
        memberTableModel4.setRowCount(0);

        ArrayList<ArrayList> getArray = planning.listPlanDue();
        Object[] tempObject = new Object[6];
        for(int i = 0; i < getArray.size(); i++){
            ArrayList tempMember = getArray.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
            tempObject[0] = title1;
            tempObject[1] = category1;
            tempObject[2] = date;
            tempObject[3] = due1;
            tempObject[4] = location1;
            tempObject[5] = mandatory1;
            memberTableModel.addRow(tempObject);
        }

        ArrayList<ArrayList> getArray2 = planning.listPlanCreate();
        Object[] tempObject2 = new Object[6];
        for(int i = 0; i < getArray2.size(); i++){
            ArrayList tempMember = getArray2.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
            tempObject2[0] = title1;
            tempObject2[1] = category1;
            tempObject2[2] = date;
            tempObject2[3] = due1;
            tempObject2[4] = location1;
            tempObject2[5] = mandatory1;
            memberTableModel2.addRow(tempObject2);
        }

        ArrayList<ArrayList> getArray3 = planning.listPlanMandatory();
        Object[] tempObject3 = new Object[6];
        for(int i = 0; i < getArray3.size(); i++){
            ArrayList tempMember = getArray3.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
                tempObject3[0] = title1;
                tempObject3[1] = category1;
                tempObject3[2] = date;
                tempObject3[3] = due1;
                tempObject3[4] = location1;
                tempObject3[5] = mandatory1;
                memberTableModel3.addRow(tempObject3);
            }

        ArrayList<ArrayList> getArray4 = planning.listCompleted();
        Object[] tempObject4 = new Object[6];
        for(int i = 0; i < getArray4.size(); i++){
            ArrayList tempMember = getArray4.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
            tempObject4[0] = title1;
            tempObject4[1] = category1;
            tempObject4[2] = date;
            tempObject4[3] = due1;
            tempObject4[4] = location1;
            tempObject4[5] = mandatory1;
            memberTableModel4.addRow(tempObject4);
        }
        
        viewTitleTextfield.setText("");
        viewDescTextfield.setText("");
        viewLocationTextfield.setText("");
        viewCreatedTextfield.setText("");
        viewDueTextfield.setText("");
        viewCategoryTextfield.setText("");
        viewMandatoryTextfield.setText("");
        viewPIDTextfield.setText("");
        viewStatusTextfield.setText("");
        completeButton.setText("Complete");
        
        planTabbedPane.setSelectedIndex(0);
        
    }//GEN-LAST:event_completeButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        String getPid = (String)viewPIDTextfield.getText();
        Integer PID = Integer.parseInt(getPid);
        
        planning.deletePlan(PID);
        
        DefaultTableModel memberTableModel = (DefaultTableModel)planTable1.getModel();
        DefaultTableModel memberTableModel2 = (DefaultTableModel)planTable2.getModel();
        DefaultTableModel memberTableModel3 = (DefaultTableModel)planTable3.getModel();
        DefaultTableModel memberTableModel4 = (DefaultTableModel)completeTable.getModel();

        memberTableModel.setRowCount(0);
        memberTableModel2.setRowCount(0);
        memberTableModel3.setRowCount(0);
        memberTableModel4.setRowCount(0);

        ArrayList<ArrayList> getArray = planning.listPlanDue();
        Object[] tempObject = new Object[6];
        for(int i = 0; i < getArray.size(); i++){
            ArrayList tempMember = getArray.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
            tempObject[0] = title1;
            tempObject[1] = category1;
            tempObject[2] = date;
            tempObject[3] = due1;
            tempObject[4] = location1;
            tempObject[5] = mandatory1;
            memberTableModel.addRow(tempObject);
        }

        ArrayList<ArrayList> getArray2 = planning.listPlanCreate();
        Object[] tempObject2 = new Object[6];
        for(int i = 0; i < getArray2.size(); i++){
            ArrayList tempMember = getArray2.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
            tempObject2[0] = title1;
            tempObject2[1] = category1;
            tempObject2[2] = date;
            tempObject2[3] = due1;
            tempObject2[4] = location1;
            tempObject2[5] = mandatory1;
            memberTableModel2.addRow(tempObject2);
        }

        ArrayList<ArrayList> getArray3 = planning.listPlanMandatory();
        Object[] tempObject3 = new Object[6];
        for(int i = 0; i < getArray3.size(); i++){
            ArrayList tempMember = getArray3.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
                tempObject3[0] = title1;
                tempObject3[1] = category1;
                tempObject3[2] = date;
                tempObject3[3] = due1;
                tempObject3[4] = location1;
                tempObject3[5] = mandatory1;
                memberTableModel3.addRow(tempObject3);
            }

        ArrayList<ArrayList> getArray4 = planning.listCompleted();
        Object[] tempObject4 = new Object[6];
        for(int i = 0; i < getArray4.size(); i++){
            ArrayList tempMember = getArray4.get(i);
            String title1 = (String)tempMember.get(0);
            String category1 = (String)tempMember.get(1);
            String date = (String)tempMember.get(2);
            String due1 = (String)tempMember.get(3);
            String location1 = (String)tempMember.get(4);
            Integer mandatory1 = (Integer)tempMember.get(5);
            tempObject4[0] = title1;
            tempObject4[1] = category1;
            tempObject4[2] = date;
            tempObject4[3] = due1;
            tempObject4[4] = location1;
            tempObject4[5] = mandatory1;
            memberTableModel4.addRow(tempObject4);
        }
        
        viewTitleTextfield.setText("");
        viewDescTextfield.setText("");
        viewLocationTextfield.setText("");
        viewCreatedTextfield.setText("");
        viewDueTextfield.setText("");
        viewCategoryTextfield.setText("");
        viewMandatoryTextfield.setText("");
        viewPIDTextfield.setText("");
        viewStatusTextfield.setText("");
        completeButton.setText("Complete");
        
        planTabbedPane.setSelectedIndex(0);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassButtonActionPerformed
        // TODO add your handling code here:
        String abbr = addAbbrTextfield.getText();
        String name = addNameTextfield.getText();
        String room = addRoomTextfield.getText();
        String pname = addPnameTextfield.getText();
        String poffice = addPofficeTextfield.getText();
        String phour = addPhourTextfield.getText();
        Integer semester = (Integer) semesterSpinner.getValue();
        Integer level = (Integer) hardnessSpinner.getValue();
        Boolean mon = monday.isSelected();
        Boolean tues = tuesday.isSelected();
        Boolean wed = wednesday.isSelected();
        Boolean thurs = thursday.isSelected();
        Boolean fri = friday.isSelected();
        Boolean sat = saturday.isSelected();
        Boolean on = online.isSelected();
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        String classStarts = dateFormat.format(classSpinner1.getValue());
        String classEnds = dateFormat.format(classSpinner2.getValue());

        ArrayList getCourses = new ArrayList();
        getCourses = course.getCourses();

        if (abbr.compareTo("") == 0){
            error.getMessage("Please enter the class abbreviation!");
        }
        else if(getCourses.contains(abbr)){
            error.getMessage("This class is already enrolled!");
        }
        else if(name.compareTo("") == 0){
            error.getMessage("Please enter the class name!");
        }
        else if(room.compareTo("") == 0){
            error.getMessage("Please enter the classroom name!");
        }
        else if(pname.compareTo("") == 0){
            error.getMessage("Please enter professor's name!");
        }
        else if(poffice.compareTo("") == 0){
            error.getMessage("Please enter professor's office location!");
        }
        else if(phour.compareTo("") == 0){
            error.getMessage("Please enter proffessor's office hour!");
        }
        else if(mon == false && tues == false && wed == false &&
            thurs == false && fri == false && sat == false && on == false){
            error.getMessage("Please choose the day!");
        }
        else{
            course.addCourse(abbr, name, room, pname, poffice, phour, semester, level, mon, tues, wed, thurs, fri, sat, on, classStarts, classEnds);
            courseBox.setModel(new javax.swing.DefaultComboBoxModel(course.getCourses().toArray()));
            semesterNumbers = course.getSemester();
            arrayLast = semesterNumbers.size()-1;
            Integer getSemesterInt = semesterNumbers.get(arrayLast);
            
            ArrayList<ArrayList> semesterGetTable = new ArrayList<ArrayList>();
            semesterGetTable = course.semesterTable(getSemesterInt);
            
            DefaultTableModel semesterTables = (DefaultTableModel)semesterTable.getModel();
            semesterTables.setRowCount(0);
            Object[] tempSemester = new Object[10];
            for(int i = 0; i < semesterGetTable.size(); i++){
                ArrayList tempSemesters = semesterGetTable.get(i);
                String cabbr = (String)tempSemesters.get(0);
                String cname = (String)tempSemesters.get(1);
                String croom = (String)tempSemesters.get(2);
                String prof = (String)tempSemesters.get(3);
                String poffice1 = (String)tempSemesters.get(4);
                String phour1 = (String)tempSemesters.get(5);
                String cdays = (String)tempSemesters.get(6);
                String ctime1 = (String)tempSemesters.get(7);
                String ctime2 = (String)tempSemesters.get(8);
                Integer clevel = (Integer)tempSemesters.get(9);
                tempSemester[0] = cabbr;
                tempSemester[1] = cname;
                tempSemester[2] = croom;
                tempSemester[3] = prof;
                tempSemester[4] = poffice1;
                tempSemester[5] = phour1;
                tempSemester[6] = cdays;
                tempSemester[7] = ctime1;
                tempSemester[8] = ctime2;
                tempSemester[9] = clevel;
                semesterTables.addRow(tempSemester);
            }
            semesterTextfield.setText("Semester: #" + getSemesterInt);
            courseTabbedPanel.setSelectedIndex(0);
            semesterNumbers = course.getSemester();
            arrayLast = semesterNumbers.size() - 1;
        } 
    }//GEN-LAST:event_addClassButtonActionPerformed

    private void removeClassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeClassButtonActionPerformed
        // TODO add your handling code here:
        String getClass = (String) courseBox.getSelectedItem();
        course.removeCourse(getClass);
        courseBox.setModel(new javax.swing.DefaultComboBoxModel(course.getCourses().toArray()));
        courseTabbedPanel.setSelectedIndex(0);
        semesterNumbers = course.getSemester();
        arrayLast = semesterNumbers.size() - 1;
    }//GEN-LAST:event_removeClassButtonActionPerformed

    private void onlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onlineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_onlineActionPerformed

    private void saturdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saturdayActionPerformed

    private void wednesdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wednesdayActionPerformed

    private void addPhourTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPhourTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPhourTextfieldActionPerformed

    private void addPofficeTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPofficeTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPofficeTextfieldActionPerformed

    private void addRoomTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRoomTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addRoomTextfieldActionPerformed

    private void addPnameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPnameTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addPnameTextfieldActionPerformed

    private void addNameTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNameTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNameTextfieldActionPerformed

    private void addAbbrTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAbbrTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAbbrTextfieldActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("before" + arrayLast);
        try{
            arrayLast = arrayLast - 1;
            System.out.println("after" + arrayLast);
            Integer getSemesterInt = semesterNumbers.get(arrayLast);
            ArrayList<ArrayList> semesterGetTable = new ArrayList<ArrayList>();
            semesterGetTable = course.semesterTable(getSemesterInt);
            DefaultTableModel semesterTables = (DefaultTableModel)semesterTable.getModel();
            semesterTables.setRowCount(0);
            Object[] tempSemester = new Object[10];
            for(int i = 0; i < semesterGetTable.size(); i++){
                ArrayList tempSemesters = semesterGetTable.get(i);
                String cabbr = (String)tempSemesters.get(0);
                String cname = (String)tempSemesters.get(1);
                String croom = (String)tempSemesters.get(2);
                String prof = (String)tempSemesters.get(3);
                String poffice1 = (String)tempSemesters.get(4);
                String phour1 = (String)tempSemesters.get(5);
                String cdays = (String)tempSemesters.get(6);
                String ctime1 = (String)tempSemesters.get(7);
                String ctime2 = (String)tempSemesters.get(8);
                Integer clevel = (Integer)tempSemesters.get(9);
                tempSemester[0] = cabbr;
                tempSemester[1] = cname;
                tempSemester[2] = croom;
                tempSemester[3] = prof;
                tempSemester[4] = poffice1;
                tempSemester[5] = phour1;
                tempSemester[6] = cdays;
                tempSemester[7] = ctime1;
                tempSemester[8] = ctime2;
                tempSemester[9] = clevel;
                semesterTables.addRow(tempSemester);
            }
            semesterTextfield.setText("Semester: #" + getSemesterInt);
        } 
        catch(Exception ex){
            error.getMessage("There is no previous semester!");
            arrayLast = 0;
        }
    }//GEN-LAST:event_prevButtonActionPerformed

    private void changeSemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeSemButtonActionPerformed
        // TODO add your handling code here:
        ArrayList<ArrayList> manyCourses = new ArrayList<ArrayList>();
        ArrayList<Integer> semesterList = course.getSemester();
        Integer semester = semesterList.get(arrayLast);
        ArrayList<ArrayList> manySemester = course.semesterTable(semester);
        
        try{
            for(int i = 0; manySemester.size() > i; i++){    
                String abbrtemp = semesterTable.getModel().getValueAt(i, 0).toString();
                String nametemp = semesterTable.getModel().getValueAt(i, 1).toString();
                String roomtemp = semesterTable.getModel().getValueAt(i, 2).toString();
                String proftemp = semesterTable.getModel().getValueAt(i, 3).toString();
                String officetemp = semesterTable.getModel().getValueAt(i, 4).toString();
                String hourtemp = semesterTable.getModel().getValueAt(i, 5).toString();
                String daystemp = semesterTable.getModel().getValueAt(i, 6).toString();
                String timetemp1 = semesterTable.getModel().getValueAt(i, 7).toString();
                String timetemp2 = semesterTable.getModel().getValueAt(i, 8).toString();
                String mandatorytemp = semesterTable .getModel().getValueAt(i, 9).toString();
                Integer intLevel = Integer.parseInt(mandatorytemp);
                course.modifyCourse(abbrtemp, nametemp, roomtemp, proftemp, officetemp, hourtemp, daystemp, timetemp1, timetemp2, intLevel);
            }
        }
            
        catch(Exception e){
            ;
        }

    }//GEN-LAST:event_changeSemButtonActionPerformed

    private void deleteSemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSemButtonActionPerformed
        // TODO add your handling code here:
        try{
            int row = semesterTable.getSelectedRow();
            String cabbr = semesterTable.getModel().getValueAt(row, 0).toString();
            course.removeCourse(cabbr);
            
            Integer getSemesterInt = semesterNumbers.get(arrayLast);
        
            ArrayList<ArrayList> semesterGetTable = new ArrayList<ArrayList>();
            semesterGetTable = course.semesterTable(getSemesterInt);

            DefaultTableModel semesterTables = (DefaultTableModel)semesterTable.getModel();
            semesterTables.setRowCount(0);
            Object[] tempSemester = new Object[10];
            for(int i = 0; i < semesterGetTable.size(); i++){
                ArrayList tempSemesters = semesterGetTable.get(i);
                String cabbr1 = (String)tempSemesters.get(0);
                String cname = (String)tempSemesters.get(1);
                String croom = (String)tempSemesters.get(2);
                String prof = (String)tempSemesters.get(3);
                String poffice1 = (String)tempSemesters.get(4);
                String phour1 = (String)tempSemesters.get(5);
                String cdays = (String)tempSemesters.get(6);
                String ctime1 = (String)tempSemesters.get(7);
                String ctime2 = (String)tempSemesters.get(8);
                Integer clevel = (Integer)tempSemesters.get(9);
                tempSemester[0] = cabbr1;
                tempSemester[1] = cname;
                tempSemester[2] = croom;
                tempSemester[3] = prof;
                tempSemester[4] = poffice1;
                tempSemester[5] = phour1;
                tempSemester[6] = cdays;
                tempSemester[7] = ctime1;
                tempSemester[8] = ctime2;
                tempSemester[9] = clevel;
                semesterTables.addRow(tempSemester);
            }
            semesterTextfield.setText("Semester: #" + getSemesterInt);
            semesterNumbers = course.getSemester();
            arrayLast = semesterNumbers.size() - 1;
            
        }
        catch(Exception e){
            error.getMessage("Please choose a class!");
        }
    }//GEN-LAST:event_deleteSemButtonActionPerformed

    private void modifyNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyNoteButtonActionPerformed
        // TODO add your handling code here:
        timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        String strTimestamp = timestamp.toString();

        String part2[] = strTimestamp.split(" ");
        String datePart[] = part2[0].split("-");
        String timePart[] = part2[1].split(":");
        Integer hourInt = Integer.parseInt(timePart[0]);
        String getTimestamp = "";

        if (hourInt == 0){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1] + " " + "AM";
        }
        else if (hourInt > 0 && hourInt < 10){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 0" + timePart[0] + ":" + timePart[1] + " " + "AM";
        }
        else if (hourInt >= 10 && hourInt < 12){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1] + " " + "AM";
        }
        else if (hourInt == 12){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1] + " " + "PM";
        }
        else if (hourInt > 12 && hourInt < 22){
            Integer hourMinus12 = hourInt - 12;
            String hourStr = Integer.toString(hourMinus12);
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 0" + hourStr + ":" + timePart[1] + " " + "PM";
        }
        else if(hourInt >= 22 && hourInt < 24){
            Integer hourMinus12 = hourInt - 12;
            String hourStr = Integer.toString(hourMinus12);
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + hourStr + ":" + timePart[1] + " " + "PM";
        }

        String getTimestamp24 = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1];
        
        String NID = noteNIDTextfield.getText();
        String titles = noteTitleTextfield.getText();
        String notes = noteNoteTextfield.getText();
        Integer intNID = Integer.parseInt(NID);
        note.modifyNote(titles, notes, getTimestamp24, intNID);
        
        ArrayList<ArrayList> tableList = new ArrayList<ArrayList>();
        tableList = note.noteTable();
        DefaultTableModel noteTableModel = (DefaultTableModel)noteTable.getModel();
        noteTableModel.setRowCount(0);
        Object[] tempListNote = new Object[4];
        for(int i = 0; i < tableList.size(); i++){
            ArrayList tempNote = tableList.get(i);
            String ntitleTemp = (String)tempNote.get(0);
            String createdTemp = (String)tempNote.get(1);
            String modifiedTemp = (String)tempNote.get(2);
            Integer NIDTemp = (Integer)tempNote.get(3);
            tempListNote[0] = ntitleTemp;
            tempListNote[1] = createdTemp;
            tempListNote[2] = modifiedTemp;
            tempListNote[3] = NIDTemp;
            noteTableModel.addRow(tempListNote);
        }
        noteTabbedPane.setSelectedIndex(0);
    }//GEN-LAST:event_modifyNoteButtonActionPerformed

    private void deleteNoteButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNoteButton2ActionPerformed
        // TODO add your handling code here:
        try{
            String nid = noteNIDTextfield.getText();
            Integer intNID = Integer.parseInt(nid);
            note.deleteNote(intNID);
           
            ArrayList<ArrayList> tableList = new ArrayList<ArrayList>();
            tableList = note.noteTable();
            DefaultTableModel noteTableModel = (DefaultTableModel)noteTable.getModel();
            noteTableModel.setRowCount(0);
            Object[] tempListNote = new Object[4];
            for(int i = 0; i < tableList.size(); i++){
                ArrayList tempNote = tableList.get(i);
                String ntitleTemp = (String)tempNote.get(0);
                String createdTemp = (String)tempNote.get(1);
                String modifiedTemp = (String)tempNote.get(2);
                Integer NIDTemp = (Integer)tempNote.get(3);
                tempListNote[0] = ntitleTemp;
                tempListNote[1] = createdTemp;
                tempListNote[2] = modifiedTemp;
                tempListNote[3] = NIDTemp;
                noteTableModel.addRow(tempListNote);
            }
            noteTabbedPane.setSelectedIndex(0);
            noteNIDTextfield.setText("");
            noteTitleTextfield.setText("");
            noteNoteTextfield.setText("");
            noteModifiedTextfield.setText("");
            noteCreatedTextfield.setText("");
        }
        catch(Exception e){
            ;
        }
    }//GEN-LAST:event_deleteNoteButton2ActionPerformed

    private void deleteNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNoteButtonActionPerformed
        // TODO add your handling code here:
        try{
            int row = noteTable.getSelectedRow();
            String nid = noteTable.getModel().getValueAt(row, 3).toString();
            Integer intNID = Integer.parseInt(nid);
            note.deleteNote(intNID);
           
            ArrayList<ArrayList> tableList = new ArrayList<ArrayList>();
            tableList = note.noteTable();
            DefaultTableModel noteTableModel = (DefaultTableModel)noteTable.getModel();
            noteTableModel.setRowCount(0);
            Object[] tempListNote = new Object[4];
            for(int i = 0; i < tableList.size(); i++){
                ArrayList tempNote = tableList.get(i);
                String ntitleTemp = (String)tempNote.get(0);
                String createdTemp = (String)tempNote.get(1);
                String modifiedTemp = (String)tempNote.get(2);
                Integer NIDTemp = (Integer)tempNote.get(3);
                tempListNote[0] = ntitleTemp;
                tempListNote[1] = createdTemp;
                tempListNote[2] = modifiedTemp;
                tempListNote[3] = NIDTemp;
                noteTableModel.addRow(tempListNote);
            }
            noteNIDTextfield.setText("");
            noteTitleTextfield.setText("");
            noteNoteTextfield.setText("");
            noteModifiedTextfield.setText("");
            noteCreatedTextfield.setText("");
        }
        catch(Exception e){
            error.getMessage("Please choose the note!");
        }
    }//GEN-LAST:event_deleteNoteButtonActionPerformed

    private void createNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNoteButtonActionPerformed
        // TODO add your handling code here:
        timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        String strTimestamp = timestamp.toString();

        String part2[] = strTimestamp.split(" ");
        String datePart[] = part2[0].split("-");
        String timePart[] = part2[1].split(":");
        Integer hourInt = Integer.parseInt(timePart[0]);
        String getTimestamp = "";

        if (hourInt == 0){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1] + " " + "AM";
        }
        else if (hourInt > 0 && hourInt < 10){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 0" + timePart[0] + ":" + timePart[1] + " " + "AM";
        }
        else if (hourInt >= 10 && hourInt < 12){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1] + " " + "AM";
        }
        else if (hourInt == 12){
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 12:" + timePart[1] + " " + "PM";
        }
        else if (hourInt > 12 && hourInt < 22){
            Integer hourMinus12 = hourInt - 12;
            String hourStr = Integer.toString(hourMinus12);
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " 0" + hourStr + ":" + timePart[1] + " " + "PM";
        }
        else if(hourInt >= 22 && hourInt < 24){
            Integer hourMinus12 = hourInt - 12;
            String hourStr = Integer.toString(hourMinus12);
            getTimestamp = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + hourStr + ":" + timePart[1] + " " + "PM";
        }

        String getTimestamp24 = datePart[0] + "/" + datePart[1] + "/" + datePart[2] + " " + timePart[0] + ":" + timePart[1];
        note.addNote(getTimestamp24);
        
        
        ArrayList<ArrayList> tableList = new ArrayList<ArrayList>();
        tableList = note.noteTable();
        DefaultTableModel noteTableModel = (DefaultTableModel)noteTable.getModel();
        noteTableModel.setRowCount(0);
        Object[] tempListNote = new Object[4];
        for(int i = 0; i < tableList.size(); i++){
            ArrayList tempNote = tableList.get(i);
            String ntitleTemp = (String)tempNote.get(0);
            String createdTemp = (String)tempNote.get(1);
            String modifiedTemp = (String)tempNote.get(2);
            Integer NIDTemp = (Integer)tempNote.get(3);
            tempListNote[0] = ntitleTemp;
            tempListNote[1] = createdTemp;
            tempListNote[2] = modifiedTemp;
            tempListNote[3] = NIDTemp;
            noteTableModel.addRow(tempListNote);
        }
    }//GEN-LAST:event_createNoteButtonActionPerformed

    private void viewNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewNoteButtonActionPerformed
        // TODO add your handling code here:
        try{
            int row = noteTable.getSelectedRow();
            String nid = noteTable.getModel().getValueAt(row, 3).toString();
            Integer intNID = Integer.parseInt(nid);
           
            ArrayList noteInfo = note.getNote(intNID);
            
            String tempTitle = (String)noteInfo.get(0);
            String tempNote = (String)noteInfo.get(1);
            String tempCreated = (String)noteInfo.get(2);
            String tempModified = (String)noteInfo.get(3);
            
            noteTitleTextfield.setText(tempTitle);
            noteNoteTextfield.setText(tempNote);
            noteCreatedTextfield.setText(tempCreated);
            noteModifiedTextfield.setText(tempModified);
            noteNIDTextfield.setText(nid);
            noteTabbedPane.setSelectedIndex(1);
        }
        catch(Exception e){
            error.getMessage("Please choose the note!");
        }
    }//GEN-LAST:event_viewNoteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ViewButton1;
    private javax.swing.JButton ViewButton2;
    private javax.swing.JButton ViewButton3;
    private javax.swing.JButton ViewButton4;
    private javax.swing.JTextField addAbbrTextfield;
    private javax.swing.JButton addClassButton;
    private javax.swing.JSpinner addDateSpinner;
    private javax.swing.JTextField addNameTextfield;
    private javax.swing.JTextField addPhourTextfield;
    private javax.swing.JLabel addPlanningOutput;
    private javax.swing.JTextField addPnameTextfield;
    private javax.swing.JTextField addPofficeTextfield;
    private javax.swing.JTextField addRoomTextfield;
    private javax.swing.JComboBox<String> categoryBox;
    private javax.swing.JTextField categoryTextfield;
    private javax.swing.JButton changeSemButton;
    private javax.swing.JSpinner classSpinner1;
    private javax.swing.JSpinner classSpinner2;
    private javax.swing.JButton completeButton;
    private javax.swing.JTable completeTable;
    private javax.swing.JComboBox<String> courseBox;
    private javax.swing.JTabbedPane courseTabbedPanel;
    private javax.swing.JButton createNoteButton;
    private javax.swing.JButton createPlanButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteNoteButton;
    private javax.swing.JButton deleteNoteButton2;
    private javax.swing.JButton deleteSemButton;
    private javax.swing.JRadioButton friday;
    private javax.swing.JPanel getDateNow;
    private javax.swing.JLabel getTimeNowTextfield;
    private javax.swing.JSpinner hardnessSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField locationTextfield;
    private javax.swing.JSlider mandatorySlider;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton modifyNoteButton;
    private javax.swing.JRadioButton monday;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField noteCreatedTextfield;
    private javax.swing.JTextField noteModifiedTextfield;
    private javax.swing.JTextField noteNIDTextfield;
    private javax.swing.JTextArea noteNoteTextfield;
    private javax.swing.JTabbedPane noteTabbedPane;
    private javax.swing.JTable noteTable;
    private javax.swing.JTextField noteTitleTextfield;
    private javax.swing.JRadioButton online;
    private javax.swing.JTextArea planDescTextfield;
    private javax.swing.JTabbedPane planTabbedPane;
    private javax.swing.JTabbedPane planTabbedPanel;
    private javax.swing.JTable planTable1;
    private javax.swing.JTable planTable2;
    private javax.swing.JTable planTable3;
    private javax.swing.JTextField planTitleTextfield;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton removeClassButton;
    private javax.swing.JRadioButton saturday;
    private javax.swing.JSpinner semesterSpinner;
    private javax.swing.JTable semesterTable;
    private javax.swing.JLabel semesterTextfield;
    private javax.swing.JLabel sliderValue;
    private javax.swing.JRadioButton thursday;
    private javax.swing.JRadioButton tuesday;
    private javax.swing.JTextField viewCategoryTextfield;
    private javax.swing.JTextField viewCreatedTextfield;
    private javax.swing.JTextArea viewDescTextfield;
    private javax.swing.JTextField viewDueTextfield;
    private javax.swing.JTextField viewLocationTextfield;
    private javax.swing.JTextField viewMandatoryTextfield;
    private javax.swing.JButton viewNoteButton;
    private javax.swing.JTextField viewPIDTextfield;
    private javax.swing.JTextField viewStatusTextfield;
    private javax.swing.JTextField viewTitleTextfield;
    private javax.swing.JRadioButton wednesday;
    // End of variables declaration//GEN-END:variables
}
