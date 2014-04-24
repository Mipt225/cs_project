import javax.swing.*;

public class Frame extends JFrame{
	private JLabel label1 = new JLabel("Halo is Gaya.");
	private JLabel label2 = new JLabel("It is Halo.");
	private JLabel label3 = new JLabel("It is Halo.");
	private JLabel label4 = new JLabel("It is Halo.");
	private JLabel label5 = new JLabel("It is Halo.");
	private JTextField field1 = new JTextField("It is Halo.");
	private JTextField field2 = new JTextField("It is Halo.");
	private JButton button1 = new JButton("Halo");
	private JButton button2 = new JButton("Halo");
	
	Frame(){}
	Frame(String str){
		super(str);//?????Why this need??
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*GroupLayout gl = new GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(gl);
		gl.setHorizontalGroup(
				gl.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gl.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label2)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(label2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addContainerGap(42, Short.MAX_VALUE))
		);*/
		
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(label1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(button1)
                    .addComponent(button2)
                    .addComponent(field2)
                    .addComponent(field1))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(field2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3))
                    .addGap(18, 18, 18)
                    .addComponent(button1)
                    .addContainerGap(166, Short.MAX_VALUE))
            );

            pack();
	}
}
