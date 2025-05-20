package services;

import java.sql.*;
import java.util.*;
import models.SanPham;

public class SanPhamService {
    private Connection conn;

    public SanPhamService() {
        conn = DBConnection.getConnection();
    }

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new SanPham(
                    rs.getInt("Ma"),
                    rs.getString("Ten"),
                    rs.getString("TrangThai"),
                    rs.getInt("GiaBan")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(SanPham sp) {
        String sql = "INSERT INTO SanPham (Ma, Ten, TrangThai, GiaBan) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, sp.getMa());
            ps.setString(2, sp.getTen());
            ps.setString(3, sp.getTrangThai());
            ps.setInt(4, sp.getGiaBan());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(SanPham sp) {
        String sql = "UPDATE SanPham SET Ten=?, TrangThai=?, GiaBan=? WHERE Ma=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sp.getTen());
            ps.setString(2, sp.getTrangThai());
            ps.setInt(3, sp.getGiaBan());
            ps.setInt(4, sp.getMa());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int ma) {
        String sql = "DELETE FROM SanPham WHERE Ma=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ma);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<SanPham> searchByGia(int min, int max) {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE GiaBan BETWEEN ? AND ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, min);
            ps.setInt(2, max);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(
                    rs.getInt("Ma"),
                    rs.getString("Ten"),
                    rs.getString("TrangThai"),
                    rs.getInt("GiaBan")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
