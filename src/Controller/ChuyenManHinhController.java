/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;



import GUI.view.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import qlbg.bean.DanhMucBean;
/**
 *
 * @author anhsa
 */
public class ChuyenManHinhController {
    private JPanel root;
    private String kindSelected="";
    private List<DanhMucBean> listItem=null;
    
   

    public ChuyenManHinhController(JPanel JpanelMain) {
        this.root = JpanelMain;
    }
    
    public void setView(JPanel jpnItem,JLabel jlbItem){
        kindSelected = "TrangChinh";
        jpnItem.setBackground(new Color(255,255,255));
        jlbItem.setBackground(new Color(255,255,255));
        JPanel node = new BanHangGUI();
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(node);
        root.validate();
        root.repaint();
    }
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem=listItem;
        for(DanhMucBean item: listItem ){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    
    }
    
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){  
                case "NhapHang":
                    node = new NhapHangGUI();
                    break;
                case "BanHang":
                    node = new BanHangGUI();
                    break;
                
                case "TaiKhoan":
                    node = new TaiKhoanGUI();
                    break;
                case "SanPham":
                    node = new SanPhamGUI();
                    break;
                case "NhaCungCap":
                    node = new NCCGUI();
                    break;
                case "HoaDon":
                    node = new HoaDonGUI();
                    break;
                case "KhachHang":
                    node = new KhachHangGUI();
                    break;
                case "KhuyenMai":
                    node = new KhuyenMaiGUI();
                    break;
                case "ThongKe":
                    node = new ThongKeGUI();
                    break;
                
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(255,255,255));
            jlbItem.setBackground(new Color(255,255,255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(255,255,255));
            jlbItem.setBackground(new Color(255,255,255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(0,102,102));
                jlbItem.setBackground(new Color(0,102,102));
            }
        }
    }
    private void setChangeBackgroud(String kind){
        for(DanhMucBean item:listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(255,255,255));
                item.getJlb().setBackground(new Color(255,255,255));
            }else{
                item.getJpn().setBackground(new Color(0,102,102));
                item.getJlb().setBackground(new Color(0,102,102));
            }
        }
    }
}
