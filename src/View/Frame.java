package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import Model.Player;

public class Frame extends JFrame {
    JPanel panel = new JPanel();
    Player player;

    public Frame(){
        panel.setLayout(new GridLayout(1,4));
        JButton repeatNo = new JButton("no repeat");
        JButton repeatOne = new JButton("repeat 1");
        JButton repeatAll = new JButton("repeat all");
        JButton play = new JButton("play");
        JButton pause = new JButton("pause");
        JButton next = new JButton("next");
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    player.starPlaying();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    player.pause();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    player.playNext();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        repeatNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setRepeat(-1);
            }
        });
        repeatOne.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setRepeat(1);
            }
        });
        repeatAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setRepeat(2);
            }
        });

        panel.add(repeatNo);
        panel.add(repeatOne);
        panel.add(repeatAll);
        panel.add(play);
        panel.add(pause);
        panel.add(next);
        add(panel);
        setSize(600, 300);
        setVisible(true);
    }
    public void setPlayer(Player player){
        this.player = player;
    }
}
