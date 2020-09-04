package com.kapcb.ccc.awt;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * <a>Title:ImageViewer</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/9/5 0:19
 */
public class ImageViewer {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ImageViewerFrame imageViewerFrame = new ImageViewerFrame();
            imageViewerFrame.setTitle("ImageViewer");
            imageViewerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            imageViewerFrame.setVisible(true);
        });
    }

}

class ImageViewerFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 300;

    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        JLabel jLabel = new JLabel();
        add(jLabel);

        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File("."));

        JMenuBar jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        JMenu jMenu = new JMenu("File");
        jMenuBar.add(jMenu);

        JMenuItem open = new JMenuItem("Open");

        jMenu.add(open);
        open.addActionListener(event -> {
            int result = jFileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = jFileChooser.getSelectedFile().getPath();
                jLabel.setIcon(new ImageIcon(name));
            }
        });

        JMenuItem exit = new JMenuItem("Exit");
        jMenu.add(exit);
        exit.addActionListener(event -> System.exit(0));

    }
}