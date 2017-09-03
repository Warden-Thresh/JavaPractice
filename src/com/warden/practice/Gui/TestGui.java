package com.warden.practice.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by Warden on 2017/9/1.
 */
public class TestGui {
    static long allFileSize = 0; // 所有需要复制的文件大小
    static long currentFileSizeCopied = 0;// 已复制的文件总大小

    /**
     * 遍历文件夹获取文件夹内容总大小
     *
     * @param file
     */
    public static void calclateAllFilesize(File file) {

        if (file.isFile()) {
            allFileSize += file.length();
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                calclateAllFilesize(f);
            }
        }

    }

    public static void main(String[] args) {

        JFrame f = new JFrame("带进度条的文件夹复制");
        f.setSize(450, 140);
        f.setLocation(200, 200);
        f.setLayout(new FlowLayout());

        // 文件地址
        JLabel lStr = new JLabel("源文件地址：");
        JTextField strTf = new JTextField("");
        strTf.setText("e:/JDK");
        strTf.setPreferredSize(new Dimension(100, 30));
        JLabel lDest = new JLabel("复制到：");
        JTextField destTf = new JTextField("");
        destTf.setText("e:/JDK2");
        destTf.setPreferredSize(new Dimension(100, 30));

        f.add(lStr);
        f.add(strTf);
        f.add(lDest);
        f.add(destTf);

        JButton bStartCopy = new JButton("开始复制");
        bStartCopy.setPreferredSize(new Dimension(100, 30));

        JLabel l = new JLabel("文件复制进度：");
        JProgressBar pb = new JProgressBar();
        pb.setMaximum(100);
        pb.setStringPainted(true);

        f.add(bStartCopy);
        f.add(l);
        f.add(pb);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);

        // 计算需要复制的文件的总大小
        String srcPath = strTf.getText();
        File folder = new File(srcPath);
        calclateAllFilesize(folder);

        // 点击开始复制
        bStartCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentFileSizeCopied = 0;
                String srcPath = strTf.getText();
                String destPath = destTf.getText();
                new Thread(() -> copyFolder(srcPath, destPath)).start();
                bStartCopy.setEnabled(false);
            }

            public void copyFile(String srcPath, String destPath) {

                File srcFile = new File(srcPath);
                File destFile = new File(destPath);

                // 缓存区，一次性读取1024字节
                byte[] buffer = new byte[1024];

                try (FileInputStream fis = new FileInputStream(srcFile);
                     FileOutputStream fos = new FileOutputStream(destFile);) {
                    while (true) {
                        // 实际读取的长度是 actuallyReaded,有可能小于1024
                        int actuallyReaded = fis.read(buffer);
                        // -1表示没有可读的内容了
                        if (-1 == actuallyReaded)
                            break;
                        fos.write(buffer, 0, actuallyReaded);
                        fos.flush();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void copyFolder(String srcPath, String destPath) {
                File srcFolder = new File(srcPath);
                File destFolder = new File(destPath);

                if (!srcFolder.exists())
                    return;

                if (!srcFolder.isDirectory())
                    return;

                if (destFolder.isFile())
                    return;

                if (!destFolder.exists())
                    destFolder.mkdirs();

                File[] files = srcFolder.listFiles();
                for (File srcFile : files) {

                    if (!(srcFile.isDirectory())) {
                        File newDestFile = new File(destFolder, srcFile.getName());
                        copyFile(srcFile.getAbsolutePath(), newDestFile.getAbsolutePath());
                        currentFileSizeCopied += srcFile.length();

                        double current = (double) currentFileSizeCopied / (double) allFileSize;
                        int progress = (int) (current * 100);
                        pb.setValue(progress);
                        if (progress == 100) {
                            JOptionPane.showMessageDialog(f, "复制完毕");
                            bStartCopy.setEnabled(true);
                        }

                    }

                    if (srcFile.isDirectory()) {
                        File newDestFolder = new File(destFolder, srcFile.getName());
                        copyFolder(srcFile.getAbsolutePath(), newDestFolder.getAbsolutePath());
                    }

                }
            }
        });
    }
}
