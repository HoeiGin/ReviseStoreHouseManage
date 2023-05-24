package gin.heoi.Frame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.util.Vector;

public class TABLE {
    public static class MTable extends JTable { // 实现自己的表格类
        public MTable(Vector rowData, Vector columnNames) {
            super(rowData, columnNames);
        }
        @Override
        public JTableHeader getTableHeader() { // 定义表格头
            // 获得表格头对象
            JTableHeader tableHeader = super.getTableHeader();
            tableHeader.setReorderingAllowed(false); // 设置表格列不可重排
            DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader
                    .getDefaultRenderer(); // 获得表格头的单元格对象
            // 设置列名居中显示
            hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            return tableHeader;
        }
        // 定义单元格
        @Override
        public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
            DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super
                    .getDefaultRenderer(columnClass); // 获得表格的单元格对象
            // 设置单元格内容居中显示
            cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            return cr;
        }
        @Override
        public boolean isCellEditable(int row, int column) { // 表格不可编辑
            return false;
        }

        @Override
        public void updateUI() {
            super.updateUI();
        }
    }
}
