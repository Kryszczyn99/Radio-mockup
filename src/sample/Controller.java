package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

import javax.naming.spi.InitialContextFactory;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    StackPane pokretlo1,pokretlo2;
    @FXML
    TextField text;
    @FXML
    Button double_up_arrow;
    String panelStyle1 = null, panelStyle2 = null;
    double lastrotation1, lastrotation2;
    int value1 = 0, value2 = 0, track_for_cd = 1;
    double current_volume=0.05 ,last_volume_before_mute;
    boolean isCdIn = false, wasDragged = false, isMuted = false, wasMuted = false, wasTurned = false, isRadioOn = false, isOnActionTurn = false;
    double freq = 100.0;
    double last_freq = 128.0;
    MediaPlayer mp1,mp2,mp3,mp4,mp5,mp6,mp7,mp8,mp9,mp10,mp11,mp12,mp13,mp14,mp_cd1,mp_cd2,mp_cd3,mp_cd4, mp_noise;
    Media m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m_cd1,m_cd2,m_cd3,m_cd4, m_noise;

    boolean isCDPlayin = false, leave_thread = false,cd_end_clip = false, was_hold_for_time1 = false, was_changing_to_fav_channel1 = false, isOnActionChangeChannel1 = false;
    MediaPlayer mp_cd;
    Media m_cd;

    boolean was_hold_for_time2 = false, was_changing_to_fav_channel2 = false, isOnActionChangeChannel2 = false;
    boolean was_hold_for_time3 = false, was_changing_to_fav_channel3 = false, isOnActionChangeChannel3 = false;
    boolean was_hold_for_time4 = false, was_changing_to_fav_channel4 = false, isOnActionChangeChannel4 = false;
    boolean was_hold_for_time5 = false, was_changing_to_fav_channel5 = false, isOnActionChangeChannel5 = false;
    boolean was_hold_for_time6 = false, was_changing_to_fav_channel6 = false, isOnActionChangeChannel6 = false;

    double freq1=113.2,freq2=126.3,freq3=108.6,freq4=105.7,freq5=111.7,freq6=120.4;
    public Controller() {
    }
    public static boolean isBetween(double x, double lower, double upper) {
        return lower <= x && x <= upper;
    }
    public void initialize(URL url, ResourceBundle rb) {
        this.panelStyle1 = this.pokretlo1.getStyle();
        this.panelStyle2 = this.pokretlo2.getStyle();
        m_noise = new Media(new File("noise.mp3").toURI().toString());
        mp_noise = new MediaPlayer(m_noise);

        m1 = new Media(new File("akon.mp3").toURI().toString());
        mp1 = new MediaPlayer(m1);

        m2 = new Media(new File("britney.mp3").toURI().toString());
        mp2 = new MediaPlayer(m2);

        m3 = new Media(new File("creedence.mp3").toURI().toString());
        mp3 = new MediaPlayer(m3);

        m4 = new Media(new File("florida.mp3").toURI().toString());
        mp4 = new MediaPlayer(m4);

        m5 = new Media(new File("genesis.mp3").toURI().toString());
        mp5 = new MediaPlayer(m5);

        m6 = new Media(new File("hold_the_line.mp3").toURI().toString());
        mp6 = new MediaPlayer(m6);

        m7 = new Media(new File("jackson.mp3").toURI().toString());
        mp7 = new MediaPlayer(m7);

        m8 = new Media(new File("john_denver.mp3").toURI().toString());
        mp8 = new MediaPlayer(m8);

        m9 = new Media(new File("marvin_gaye.mp3").toURI().toString());
        mp9 = new MediaPlayer(m9);

        m10 = new Media(new File("modern.mp3").toURI().toString());
        mp10 = new MediaPlayer(m10);

        m11 = new Media(new File("rasputin.mp3").toURI().toString());
        mp11 = new MediaPlayer(m11);

        m12 = new Media(new File("Stayin alive.mp3").toURI().toString());
        mp12 = new MediaPlayer(m12);

        m13 = new Media(new File("wham.mp3").toURI().toString());
        mp13 = new MediaPlayer(m13);

        m14 = new Media(new File("wiz.mp3").toURI().toString());
        mp14 = new MediaPlayer(m14);
/*
        m_cd1 = new Media(new File("aha.mp3").toURI().toString());
        mp_cd1 = new MediaPlayer(m_cd1);

        m_cd2 = new Media(new File("akcent.mp3").toURI().toString());
        mp_cd2 = new MediaPlayer(m_cd2);

        m_cd3 = new Media(new File("onerep.mp3").toURI().toString());
        mp_cd3 = new MediaPlayer(m_cd3);

        m_cd4 = new Media(new File("nevergonna.mp3").toURI().toString());
        mp_cd4 = new MediaPlayer(m_cd4);
*/
        Font myfont = Font.loadFont(getClass().getResourceAsStream("seg.ttf"),40);
        text.setFont(myfont);


    }
    public MediaPlayer return_song_by_freq(double freq_now) {
        if (freq_now >= 126.0 && freq_now <= 126.5) {
            return mp6;
        } else if (freq_now >= 124.2 && freq_now <= 124.7) {
            return mp4;
        } else if (freq_now >= 122.0 && freq_now <= 122.5) {
            return mp9;
        } else if (freq_now >= 120.1 && freq_now <= 120.6) {
            return mp12;
        } else if (freq_now >= 118.6 && freq_now <= 119.1) {
            return mp14;
        } else if (freq_now >= 117.0 && freq_now <= 117.5) {
            return mp10;
        } else if (freq_now >= 115.2 && freq_now <= 115.7) {
            return mp3;
        } else if (freq_now >= 113.4 && freq_now <= 113.9) {
            return mp8;
        } else if (freq_now >= 111.4 && freq_now <= 111.9) {
            return mp11;
        } else if (freq_now >= 110.0 && freq_now <= 110.5) {
            return mp5;
        } else if (freq_now >= 108.3 && freq_now <= 108.8) {
            return mp7;
        } else if (freq_now >= 105.2 && freq_now <= 106.3) {
            return mp13;
        }
        else if(freq_now>=103.4 && freq_now<=103.9) {
            return mp2;
        }
        else if(freq_now>=101.7 && freq_now<=102.2) {
            return mp1;
        }
        else return mp_noise;
    }
    public double freq_seeker_up(double freq_now)
    {
        if(freq_now>=126.6) return 102.0;
        else if(freq_now>=124.8 && freq_now<=126.5) return 102.0;
        else if(freq_now>=122.6 && freq_now<=124.7) return 126.3;
        else if(freq_now>=120.7 && freq_now<=122.5) return 124.5;
        else if(freq_now>=119.2 && freq_now<=120.6) return 122.3;
        else if(freq_now>=117.6 && freq_now<=119.1) return 120.3;
        else if(freq_now>=115.8 && freq_now<=117.5) return 118.9;
        else if(freq_now>=114.0 && freq_now<=115.7) return 117.3;
        else if(freq_now>=112.0 && freq_now<=113.9) return 115.5;
        else if(freq_now>=110.6 && freq_now<=111.9) return 113.6;
        else if(freq_now>=108.9 && freq_now<=110.5) return 111.7;
        else if(freq_now>=106.4 && freq_now<=108.8) return 110.3;
        else if(freq_now>=104.0 && freq_now<=106.3) return 108.6;
        else if(freq_now>=102.3 && freq_now<=103.9) return 105.8;
        else return 103.6;
    }
    public double freq_seeker_down(double freq_now)
    {
        if(freq_now>=126.6) return 126.3;
        else if(freq_now>=124.8 && freq_now<=126.5) return 124.5;
        else if(freq_now>=122.6 && freq_now<=124.7) return 122.3;
        else if(freq_now>=120.7 && freq_now<=122.5) return 120.3;
        else if(freq_now>=119.2 && freq_now<=120.6) return 118.9;
        else if(freq_now>=117.6 && freq_now<=119.1) return 117.3;
        else if(freq_now>=115.8 && freq_now<=117.5) return 115.5;
        else if(freq_now>=114.0 && freq_now<=115.7) return 113.6;
        else if(freq_now>=112.0 && freq_now<=113.9) return 111.7;
        else if(freq_now>=110.6 && freq_now<=111.9) return 110.3;
        else if(freq_now>=108.9 && freq_now<=110.5) return 108.6;
        else if(freq_now>=106.4 && freq_now<=108.8) return 105.8;
        else if(freq_now>=104.0 && freq_now<=106.3) return 103.6;
        else if(freq_now>=102.3 && freq_now<=103.9) return 102.0;
        else return 126.3;
    }
    public void stop_all_music()
    {
        if(mp1!=null) mp1.pause();
        if(mp2!=null) mp2.pause();
        if(mp3!=null) mp3.pause();
        if(mp4!=null) mp4.pause();
        if(mp5!=null) mp5.pause();
        if(mp6!=null) mp6.pause();
        if(mp7!=null) mp7.pause();
        if(mp8!=null) mp8.pause();
        if(mp9!=null) mp9.pause();
        if(mp10!=null) mp10.pause();
        if(mp11!=null) mp11.pause();
        if(mp12!=null) mp12.pause();
        if(mp13!=null) mp13.pause();
        if(mp14!=null) mp14.pause();
        if(mp_noise!=null) mp_noise.pause();
        if(mp_cd!=null) mp_cd.stop();
    }
    public void stop_all_music_without_noise()
    {
        if(mp1!=null) mp1.pause();
        if(mp2!=null) mp2.pause();
        if(mp3!=null) mp3.pause();
        if(mp4!=null) mp4.pause();
        if(mp5!=null) mp5.pause();
        if(mp6!=null) mp6.pause();
        if(mp7!=null) mp7.pause();
        if(mp8!=null) mp8.pause();
        if(mp9!=null) mp9.pause();
        if(mp10!=null) mp10.pause();
        if(mp11!=null) mp11.pause();
        if(mp12!=null) mp12.pause();
        if(mp13!=null) mp13.pause();
        if(mp14!=null) mp14.pause();

    }
    public void set_all_music_volume()
    {
        if(mp1!=null) mp1.setVolume(current_volume);
        if(mp2!=null) mp2.setVolume(current_volume);
        if(mp3!=null) mp3.setVolume(current_volume);
        if(mp4!=null) mp4.setVolume(current_volume);
        if(mp5!=null) mp5.setVolume(current_volume);
        if(mp6!=null) mp6.setVolume(current_volume);
        if(mp7!=null) mp7.setVolume(current_volume);
        if(mp8!=null) mp8.setVolume(current_volume);
        if(mp9!=null) mp9.setVolume(current_volume);
        if(mp10!=null) mp10.setVolume(current_volume);
        if(mp11!=null) mp11.setVolume(current_volume);
        if(mp12!=null) mp12.setVolume(current_volume);
        if(mp13!=null) mp13.setVolume(current_volume);
        if(mp14!=null) mp14.setVolume(current_volume);
        if(mp_noise!=null) mp_noise.setVolume(current_volume);
        if(mp_cd!=null) mp_cd.setVolume(current_volume);
    }
    public class ThreadToDisplayTextAndClear extends Thread
    {
        String textToDisplay;
        ThreadToDisplayTextAndClear(String t)
        {
            textToDisplay = t;
        }
        public void run()
        {
            text.setText(textToDisplay);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            text.setText("");
        }
    }
    public class ThreadToDisplayTextTurnOn extends Thread
    {
        String textToDisplay;
        ThreadToDisplayTextTurnOn(String t)
        {
            textToDisplay = t;
        }
        public void run()
        {
            text.setText(textToDisplay);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            text.setText("");
            text.setText("CHANNEL " +freq);
            MediaPlayer temp = return_song_by_freq(freq);
            temp.play();
            set_all_music_volume();
        }
    }
    public class TurnRadioThread extends Thread
    {
        public void run()
        {
            isOnActionTurn = true;
            int i=0;
            boolean breakthis = false;
            while(i<20)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(wasDragged || wasMuted)
                {
                    breakthis = true;
                    break;
                }
                i++;
            }
            if(!breakthis)
            {
                if(!wasDragged && !wasMuted)
                {
                    wasTurned = true;
                    if(isRadioOn)
                    {
                        isRadioOn = false;
                        stop_all_music();
                        ThreadToDisplayTextAndClear th = new ThreadToDisplayTextAndClear("TURN OFF RADIO");
                        th.start();
                    }
                    else
                    {
                        isRadioOn = true;
                        ThreadToDisplayTextTurnOn th = new ThreadToDisplayTextTurnOn("TURN ON RADIO");
                        th.start();
                    }
                    //System.out.println("On/Off");

                }
            }


            isOnActionTurn = false;
        }
    }
    public void reset_mouse_bool(MouseEvent me)
    {
        wasDragged = false;
        wasMuted = false;
        wasTurned = false;
        if(!isOnActionTurn)
        {
            TurnRadioThread th = new TurnRadioThread();
            th.start();
        }
    }
    public void mute(MouseEvent me)
    {
        if(!wasDragged && !wasTurned && isRadioOn)
        {
            //System.out.println("Mute");
            if(isMuted)
            {
                current_volume = last_volume_before_mute;
                set_all_music_volume();
                isMuted = false;
                text.setText("");
                text.setText("CHANNEL "+freq);
            }
            else
            {
                last_volume_before_mute = current_volume;
                current_volume = 0;
                set_all_music_volume();
                isMuted = true;
                text.setText("");
                text.setText("MUTE");

            }
            wasMuted = true;
        }


    }
    public void mousedrag1(MouseEvent me) {

        if(!wasTurned)
        {
            //System.out.println("Drag");
            wasDragged = true;
            if (this.lastrotation1 - me.getScreenX() > 0.0D) {
                this.value1 += 3;
                if(current_volume>=1.0)
                {
                    current_volume = 1.00;
                }
                else
                {
                    current_volume+=0.01;
                    double current = (double)Math.round(current_volume*100)/100;
                    current_volume = current;
                }
                set_all_music_volume();
                int value = (int)(current_volume*100);
                if(isRadioOn)
                {
                    text.setText("");
                    text.setText("VOLUME "+value);
                }

                this.pokretlo1.setStyle(this.panelStyle1 + "-fx-rotate: " + this.value1 + ";");
            } else {
                this.value1 -= 3;
                if(current_volume>0)
                {
                    current_volume-=0.01;
                    double current = (double)Math.round(current_volume*100)/100;
                    current_volume = current;
                }
                else current_volume = 0.00;
                int value = (int)(current_volume*100);
                if(isRadioOn)
                {
                    text.setText("");
                    text.setText("VOLUME "+value);
                }
                set_all_music_volume();
                this.pokretlo1.setStyle(this.panelStyle1 + "-fx-rotate: " + this.value1 + ";");
            }

            this.lastrotation1 = me.getScreenX();
        }

    }
    public void mousedrag2(MouseEvent me) {
        force_end_cd();
        isCDPlayin = false;
        last_freq = freq;
        if (this.lastrotation2 - me.getScreenX() > 0.0D) {
            this.value2 += 3;
            if(freq==128.0) freq=100.0;
            else freq+=0.1;

            this.pokretlo2.setStyle(this.panelStyle2 + "-fx-rotate: " + this.value2 + ";");
        } else {
            this.value2 -= 3;
            if(freq==100.0) freq=128.0;
            else freq-=0.1;
            this.pokretlo2.setStyle(this.panelStyle2 + "-fx-rotate: " + this.value2 + ";");
        }

        double current = (double)Math.round(freq*10)/10;
        freq = current;
        if(isRadioOn)
        {
            text.setText("");
            text.setText("CHANNEL "+freq);
        }
        if(isRadioOn)
        {
            if(isBetween(freq,101.7,102.2))
            {
                if(!isBetween(last_freq,101.7,102.2))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp1.play();
                }
            }
            else if(isBetween(freq,103.4,103.9))
            {
                if(!isBetween(last_freq,103.4,103.9))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp2.play();
                }
            }
            else if(isBetween(freq,105.2,106.3))
            {
                if(!isBetween(last_freq,105.2,106.3))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp13.play();
                }
            }
            else if(isBetween(freq,108.3,108.8))
            {
                if(!isBetween(last_freq,108.3,108.8))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp7.play();
                }
            }
            else if(isBetween(freq,110.0,110.5))
            {
                if(!isBetween(last_freq,110.0,110.5))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp5.play();
                }
            }
            else if(isBetween(freq,111.4,111.9))
            {
                if(!isBetween(last_freq,111.4,111.9))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp11.play();
                }
            }
            else if(isBetween(freq,113.4,113.9))
            {
                if(!isBetween(last_freq,113.4,113.9))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp8.play();
                }
            }
            else if(isBetween(freq,115.2,115.7))
            {
                if(!isBetween(last_freq,115.2,115.7))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp3.play();
                }
            }
            else if(isBetween(freq,117.0,117.5))
            {
                if(!isBetween(last_freq,117.0,117.5))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp10.play();
                }
            }
            else if(isBetween(freq,118.6,119.1))
            {
                if(!isBetween(last_freq,118.6,119.1))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp14.play();
                }
            }
            else if(isBetween(freq,120.1,120.6))
            {
                if(!isBetween(last_freq,120.1,120.6))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp12.play();
                }
            }
            else if(isBetween(freq,122.0,122.5))
            {
                if(!isBetween(last_freq,122.0,122.5))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp9.play();
                }
            }
            else if(isBetween(freq,124.2,124.7))
            {
                if(!isBetween(last_freq,124.2,124.7))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp4.play();
                }
            }
            else if(isBetween(freq,126.0,126.5))
            {
                if(!isBetween(last_freq,126.0,126.5))
                {
                    stop_all_music();
                    set_all_music_volume();
                    mp6.play();
                }
            }
            else
            {
                stop_all_music_without_noise();
                set_all_music_volume();
                mp_noise.play();
            }
        }

        this.lastrotation2 = me.getScreenX();
    }
    public class ThreadCounterForChannel1 extends Thread
    {
        public void run()
        {
            isOnActionChangeChannel1 = true;
            int i=0;
            boolean breakthis = false;
            while(i<20)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(was_changing_to_fav_channel1)
                {
                    breakthis = true;
                    break;
                }
                i++;
            }
            if(!breakthis)
            {
                ThreadToDisplayText th = new ThreadToDisplayText("CHANGE FAV.1");
                th.start();
                freq1=freq;
            }


            isOnActionChangeChannel1 = false;
        }
    }
    public void count_time_for_change1(MouseEvent me)
    {
        if(isRadioOn && !isOnActionChangeChannel1)
        {
            was_changing_to_fav_channel1=false;
            ThreadCounterForChannel1 th = new ThreadCounterForChannel1();
            th.start();

        }

    }
    public void button_pressed_1(MouseEvent ae)
    {
        if(isRadioOn && !was_hold_for_time1)
        {
            if(freq != freq1)
            {
                stop_all_music();
                set_all_music_volume();
                MediaPlayer temp = return_song_by_freq(freq1);
                temp.play();
                freq = freq1;
                last_freq = freq1-0.1;
                text.setText("");
                text.setText("CHANNEL "+freq);
            }
            was_changing_to_fav_channel1=true;
        }
        isCDPlayin = false;
    }
    public class ThreadCounterForChannel2 extends Thread
    {
        public void run()
        {
            isOnActionChangeChannel2 = true;
            int i=0;
            boolean breakthis = false;
            while(i<20)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(was_changing_to_fav_channel2)
                {
                    breakthis = true;
                    break;
                }
                i++;
            }
            if(!breakthis)
            {
                ThreadToDisplayText th = new ThreadToDisplayText("CHANGE FAV.2");
                th.start();
                freq2=freq;
            }


            isOnActionChangeChannel2 = false;
        }
    }
    public void count_time_for_change2(MouseEvent me)
    {
        if(isRadioOn && !isOnActionChangeChannel2)
        {
            was_changing_to_fav_channel2=false;
            ThreadCounterForChannel2 th = new ThreadCounterForChannel2();
            th.start();

        }

    }
    public void button_pressed_2(MouseEvent ae)
    {
        if(isRadioOn && !was_hold_for_time2)
        {
            if(freq != freq2)
            {
                stop_all_music();
                set_all_music_volume();
                MediaPlayer temp = return_song_by_freq(freq2);
                temp.play();
                freq = freq2;
                last_freq = freq2-0.1;
                text.setText("");
                text.setText("CHANNEL "+freq);
            }
            was_changing_to_fav_channel2=true;
        }
        isCDPlayin = false;
    }
    public class ThreadCounterForChannel3 extends Thread
    {
        public void run()
        {
            isOnActionChangeChannel3 = true;
            int i=0;
            boolean breakthis = false;
            while(i<20)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(was_changing_to_fav_channel3)
                {
                    breakthis = true;
                    break;
                }
                i++;
            }
            if(!breakthis)
            {
                ThreadToDisplayText th = new ThreadToDisplayText("CHANGE FAV.3");
                th.start();
                freq3=freq;
            }


            isOnActionChangeChannel3 = false;
        }
    }
    public void count_time_for_change3(MouseEvent me)
    {
        if(isRadioOn && !isOnActionChangeChannel3)
        {
            was_changing_to_fav_channel3=false;
            ThreadCounterForChannel3 th = new ThreadCounterForChannel3();
            th.start();

        }

    }
    public void button_pressed_3(MouseEvent ae)
    {
        if(isRadioOn && !was_hold_for_time3)
        {
            if (freq != freq3)
            {
                stop_all_music();
                set_all_music_volume();
                MediaPlayer temp = return_song_by_freq(freq3);
                temp.play();
                freq = freq3;
                last_freq = freq3-0.1;
                text.setText("");
                text.setText("CHANNEL "+freq);
            }
            was_changing_to_fav_channel3=true;
        }
        isCDPlayin = false;
    }
    public class ThreadCounterForChannel4 extends Thread
    {
        public void run()
        {
            isOnActionChangeChannel4 = true;
            int i=0;
            boolean breakthis = false;
            while(i<20)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(was_changing_to_fav_channel4)
                {
                    breakthis = true;
                    break;
                }
                i++;
            }
            if(!breakthis)
            {
                ThreadToDisplayText th = new ThreadToDisplayText("CHANGE FAV.4");
                th.start();
                freq4=freq;
            }


            isOnActionChangeChannel4 = false;
        }
    }
    public void count_time_for_change4(MouseEvent me)
    {
        if(isRadioOn && !isOnActionChangeChannel4)
        {
            was_changing_to_fav_channel4=false;
            ThreadCounterForChannel4 th = new ThreadCounterForChannel4();
            th.start();

        }

    }
    public void button_pressed_4(MouseEvent ae)
    {
        if(isRadioOn && !was_hold_for_time4)
        {
            if(freq != freq4)
            {
                stop_all_music();
                set_all_music_volume();
                MediaPlayer temp = return_song_by_freq(freq4);
                temp.play();
                freq  = freq4;
                last_freq = freq4-0.1;
                text.setText("");
                text.setText("CHANNEL "+freq);
            }
            was_changing_to_fav_channel4=true;
        }
        isCDPlayin = false;
    }
    public class ThreadCounterForChannel5 extends Thread
    {
        public void run()
        {
            isOnActionChangeChannel5 = true;
            int i=0;
            boolean breakthis = false;
            while(i<20)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(was_changing_to_fav_channel5)
                {
                    breakthis = true;
                    break;
                }
                i++;
            }
            if(!breakthis)
            {
                ThreadToDisplayText th = new ThreadToDisplayText("CHANGE FAV.5");
                th.start();
                freq5=freq;
            }


            isOnActionChangeChannel5 = false;
        }
    }
    public void count_time_for_change5(MouseEvent me)
    {
        if(isRadioOn && !isOnActionChangeChannel5)
        {
            was_changing_to_fav_channel5=false;
            ThreadCounterForChannel5 th = new ThreadCounterForChannel5();
            th.start();

        }

    }
    public void button_pressed_5(MouseEvent ae)
    {
        if(isRadioOn && !was_hold_for_time5)
        {
            if(freq!=freq5)
            {
                stop_all_music();
                set_all_music_volume();
                MediaPlayer temp = return_song_by_freq(freq5);
                temp.play();
                freq = freq5;
                last_freq = freq5-0.1;
                text.setText("");
                text.setText("CHANNEL "+freq);
            }
            was_changing_to_fav_channel5=true;
        }
        isCDPlayin = false;
    }
    public class ThreadCounterForChannel6 extends Thread
    {
        public void run()
        {
            isOnActionChangeChannel6 = true;
            int i=0;
            boolean breakthis = false;
            while(i<20)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(was_changing_to_fav_channel6)
                {
                    breakthis = true;
                    break;
                }
                i++;
            }
            if(!breakthis)
            {
                ThreadToDisplayText th = new ThreadToDisplayText("CHANGE FAV.6");
                th.start();
                freq6=freq;
            }


            isOnActionChangeChannel6 = false;
        }
    }
    public void count_time_for_change6(MouseEvent me)
    {
        if(isRadioOn && !isOnActionChangeChannel6)
        {
            was_changing_to_fav_channel6=false;
            ThreadCounterForChannel6 th = new ThreadCounterForChannel6();
            th.start();

        }

    }
    public void button_pressed_6(MouseEvent ae)
    {
        if(isRadioOn && !was_hold_for_time6)
        {
            if(freq!=freq6)
            {
                stop_all_music();
                set_all_music_volume();
                MediaPlayer temp = return_song_by_freq(freq6);
                temp.play();
                freq = freq6;
                last_freq = freq6-0.1;
                text.setText("");
                text.setText("CHANNEL "+freq);
            }
            was_changing_to_fav_channel6=true;
        }
        isCDPlayin = false;
    }
    public class DelaySeekThread extends Thread
    {
        double next_freq;

        DelaySeekThread(double nf)
        {
            next_freq=nf;
        }
        public void run()
        {
            stop_all_music();
            set_all_music_volume();
            mp_noise.play();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            text.setText("");
            text.setText("FOUND!");
            stop_all_music();
            set_all_music_volume();
            MediaPlayer temp = return_song_by_freq(next_freq);
            temp.play();
            set_all_music_volume();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            text.setText("");
            text.setText("CHANNEL "+next_freq);
        }
    }
    public void seek_up(ActionEvent ae)
    {
        if(isCDPlayin)
        {
            leave_thread = true;
            cd_end_clip = true;
            stop_all_music();
            if(track_for_cd>=4) track_for_cd = 1;
            else track_for_cd+=1;
            ThreadForCd th = new ThreadForCd();
            th.start();
        }
        else if(isRadioOn)
        {
            text.setText("");
            text.setText("SEEK....");
            double new_freq = freq_seeker_up(freq);
            freq=new_freq;
            last_freq=freq+0.1;
            DelaySeekThread th = new DelaySeekThread(freq);
            th.start();
        }
    }
    public void seek_down(ActionEvent ae)
    {
        if(isCDPlayin)
        {
            leave_thread = true;
            cd_end_clip = true;
            stop_all_music();
            if(track_for_cd<=1) track_for_cd = 4;
            else track_for_cd-=1;
            ThreadForCd th = new ThreadForCd();
            th.start();
        }
        else if(isRadioOn)
        {
            text.setText("");
            text.setText("SEEK....");
            double new_freq = freq_seeker_down(freq);
            freq=new_freq;
            last_freq=freq-0.1;
            DelaySeekThread th = new DelaySeekThread(freq);
            th.start();
        }

    }
    public class ThreadToDisplayText extends Thread
    {
        String textToDisplay;
        String lasttext;
        ThreadToDisplayText(String t)
        {
            textToDisplay = t;
            lasttext = text.getText();
        }
        public void run()
        {
            text.setText(textToDisplay);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            text.setText(lasttext);
        }
    }

    public void eject_cd(ActionEvent ae)
    {

        if(isCdIn && isRadioOn)
        {
            text.setText("");
            text.setText("CHANNEL "+freq);
            ThreadToDisplayText th = new ThreadToDisplayText("CD DISK OUT");
            th.start();
            isCdIn = false;
            if(isCDPlayin)
            {
                force_end_cd();
                MediaPlayer temp = return_song_by_freq(freq);
                temp.play();
                isCDPlayin = false;
            }

        }
    }
    public void use_cd(ActionEvent ae)
    {
        if(!isCdIn && isRadioOn)
        {
            ThreadToDisplayText th = new ThreadToDisplayText("CD DISK IN");
            th.start();

            isCdIn = true;
        }
    }







    public void take_cd_track(int number)
    {
        if(number==1)
        {
            m_cd = new Media(new File("aha.mp3").toURI().toString());
            mp_cd = new MediaPlayer(m_cd);
        }
        else if(number==2)
        {
            m_cd = new Media(new File("akcent.mp3").toURI().toString());
            mp_cd = new MediaPlayer(m_cd);
        }
        else if(number==3)
        {
            m_cd = new Media(new File("onerep.mp3").toURI().toString());
            mp_cd = new MediaPlayer(m_cd);
        }
        else if(number==4)
        {
            m_cd = new Media(new File("nevergonna.mp3").toURI().toString());
            mp_cd = new MediaPlayer(m_cd);
        }
    }
    public void force_end_cd()
    {
        cd_end_clip = true;
        leave_thread = true;
        if(mp_cd!=null)mp_cd.stop();
    }
    public class ThreadForCd extends Thread
    {
        public void run()
        {
            text.setText("");
            text.setText("CD-TRACK " + track_for_cd);
            take_cd_track(track_for_cd);
            mp_cd.play();
            mp_cd.setVolume(current_volume);
            ThreadToDisplayText th = new ThreadToDisplayText("CD MUSIC PLAY");
            th.start();

            while(true)
            {
                while(!cd_end_clip)
                {
                    mp_cd.setOnEndOfMedia(() ->{
                       System.out.println("Koniec!");
                       cd_end_clip = true;
                    });
                }
                System.out.println(text.getText());
                if(leave_thread)
                {
                    System.out.println("Leave!");
                    cd_end_clip = false;
                    leave_thread = false;
                    break;
                }

                if(track_for_cd>=4) track_for_cd=1;
                else track_for_cd+=1;
                text.setText("");
                text.setText("CD-TRACK " + track_for_cd);
                take_cd_track(track_for_cd);
                mp_cd.stop();
                mp_cd.play();
                set_all_music_volume();
                cd_end_clip = false;
                leave_thread = false;

            }
        }
    }
    public void cd_music(ActionEvent ae)
    {

        if(isCdIn && isRadioOn && !isCDPlayin)
        {
            stop_all_music();
            ThreadForCd th = new ThreadForCd();
            th.start();
            isCDPlayin = true;
        }
    }
}
