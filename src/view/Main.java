package view;

/**
 *
 * @author 7R0N1X
 */
public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JP_Background = new javax.swing.JPanel();
        JL_FolderPath = new javax.swing.JLabel();
        JTF_FolderPath = new javax.swing.JTextField();
        JL_Artist = new javax.swing.JLabel();
        JTF_Artist = new javax.swing.JTextField();
        JTF_Album = new javax.swing.JTextField();
        JL_Album = new javax.swing.JLabel();
        JTF_Year = new javax.swing.JTextField();
        JL_Year = new javax.swing.JLabel();
        JL_Publisher = new javax.swing.JLabel();
        JTF_Publisher = new javax.swing.JTextField();
        JL_Copyright = new javax.swing.JLabel();
        JTF_Copyright = new javax.swing.JTextField();
        JL_Cover = new javax.swing.JLabel();
        JMB_Menu = new javax.swing.JMenuBar();
        JM_File = new javax.swing.JMenu();
        JMI_SelectFolder = new javax.swing.JMenuItem();
        JMI_SelectCover = new javax.swing.JMenuItem();
        JM_Tools = new javax.swing.JMenu();
        JMI_EditAllFiles = new javax.swing.JMenuItem();
        JMI_GenerateList = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JP_Background.setBackground(new java.awt.Color(244, 247, 249));

        JL_FolderPath.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JL_FolderPath.setText("Folder Path:");

        JTF_FolderPath.setEditable(false);

        JL_Artist.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JL_Artist.setText("Artist:");

        JTF_Artist.setEditable(false);
        JTF_Artist.setText("www.bpmlatino.blogspot.com");

        JTF_Album.setEditable(false);
        JTF_Album.setText("Mundo Dj");

        JL_Album.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JL_Album.setText("Album:");

        JTF_Year.setEditable(false);

        JL_Year.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JL_Year.setText("Year:");

        JL_Publisher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JL_Publisher.setText("Publisher:");

        JTF_Publisher.setEditable(false);
        JTF_Publisher.setText("Mundo Dj");

        JL_Copyright.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JL_Copyright.setText("Copyright:");

        JTF_Copyright.setEditable(false);
        JTF_Copyright.setText("Mundo Dj");

        JL_Cover.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout JP_BackgroundLayout = new javax.swing.GroupLayout(JP_Background);
        JP_Background.setLayout(JP_BackgroundLayout);
        JP_BackgroundLayout.setHorizontalGroup(
            JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JL_Cover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(JP_BackgroundLayout.createSequentialGroup()
                        .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JTF_FolderPath)
                            .addComponent(JL_FolderPath)
                            .addGroup(JP_BackgroundLayout.createSequentialGroup()
                                .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JL_Artist)
                                    .addComponent(JTF_Artist, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTF_Album, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JL_Album))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JL_Year)
                                    .addComponent(JTF_Year)))
                            .addGroup(JP_BackgroundLayout.createSequentialGroup()
                                .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTF_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JL_Publisher))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JL_Copyright)
                                    .addComponent(JTF_Copyright, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_BackgroundLayout.setVerticalGroup(
            JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_BackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JL_FolderPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTF_FolderPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Artist)
                    .addComponent(JL_Album)
                    .addComponent(JL_Year))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Artist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Album, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JL_Publisher)
                    .addComponent(JL_Copyright))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTF_Copyright, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JL_Cover, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JM_File.setText("File");
        JM_File.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JMI_SelectFolder.setText("Select Folder");
        JMI_SelectFolder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JMI_SelectFolder.setMargin(new java.awt.Insets(0, 0, 0, 0));
        JM_File.add(JMI_SelectFolder);

        JMI_SelectCover.setText("Select Cover");
        JMI_SelectCover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JMI_SelectCover.setMargin(new java.awt.Insets(0, 0, 0, 0));
        JM_File.add(JMI_SelectCover);

        JMB_Menu.add(JM_File);

        JM_Tools.setText("Tools");
        JM_Tools.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JMI_EditAllFiles.setText("Edit All Files");
        JMI_EditAllFiles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JMI_EditAllFiles.setMargin(new java.awt.Insets(0, 0, 0, 0));
        JM_Tools.add(JMI_EditAllFiles);

        JMI_GenerateList.setText("Generate List");
        JMI_GenerateList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JMI_GenerateList.setMargin(new java.awt.Insets(0, 0, 0, 0));
        JM_Tools.add(JMI_GenerateList);

        JMB_Menu.add(JM_Tools);

        setJMenuBar(JMB_Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_Album;
    private javax.swing.JLabel JL_Artist;
    private javax.swing.JLabel JL_Copyright;
    public javax.swing.JLabel JL_Cover;
    private javax.swing.JLabel JL_FolderPath;
    private javax.swing.JLabel JL_Publisher;
    private javax.swing.JLabel JL_Year;
    private javax.swing.JMenuBar JMB_Menu;
    public javax.swing.JMenuItem JMI_EditAllFiles;
    public javax.swing.JMenuItem JMI_GenerateList;
    public javax.swing.JMenuItem JMI_SelectCover;
    public javax.swing.JMenuItem JMI_SelectFolder;
    private javax.swing.JMenu JM_File;
    public javax.swing.JMenu JM_Tools;
    private javax.swing.JPanel JP_Background;
    public javax.swing.JTextField JTF_Album;
    public javax.swing.JTextField JTF_Artist;
    public javax.swing.JTextField JTF_Copyright;
    public javax.swing.JTextField JTF_FolderPath;
    public javax.swing.JTextField JTF_Publisher;
    public javax.swing.JTextField JTF_Year;
    // End of variables declaration//GEN-END:variables
}
