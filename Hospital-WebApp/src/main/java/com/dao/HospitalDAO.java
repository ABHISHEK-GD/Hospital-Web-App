package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.model.Patient;

public class HospitalDAO {

    // ---------------- ADD PATIENT ----------------
    public boolean addPatient(int id, String name, int age, String gender,
                              String date, String ailment, String doctor) {

        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String query =
                "INSERT INTO Patients (PatientID, PatientName, Age, Gender, AdmissionDate, Ailment, AssignedDoctor) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, gender);
            ps.setString(5, date);
            ps.setString(6, ailment);
            ps.setString(7, doctor);

            int rows = ps.executeUpdate();

            if (rows > 0) status = true;

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ---------------- GET ALL PATIENTS ----------------
    public ArrayList<String[]> getAllPatients() {

        ArrayList<String[]> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM Patients";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("ROW FOUND"); // 🔥 DEBUG

                String[] row = new String[7];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);

                list.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ---------------- SEARCH PATIENTS ----------------
    public ArrayList<String[]> searchPatients(String search) {

        ArrayList<String[]> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps;

            try {
                int id = Integer.parseInt(search);

                ps = con.prepareStatement(
                    "SELECT * FROM Patients WHERE PatientID=? OR PatientName LIKE ?"
                );
                ps.setInt(1, id);
                ps.setString(2, "%" + search + "%");

            } catch (Exception e) {

                ps = con.prepareStatement(
                    "SELECT * FROM Patients WHERE PatientName LIKE ?"
                );
                ps.setString(1, "%" + search + "%");
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String[] row = new String[7];

                row[0] = rs.getString("PatientID");
                row[1] = rs.getString("PatientName");
                row[2] = rs.getString("Age");
                row[3] = rs.getString("Gender");
                row[4] = rs.getString("AdmissionDate");
                row[5] = rs.getString("Ailment");
                row[6] = rs.getString("AssignedDoctor");

                list.add(row);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ---------------- DELETE PATIENT ----------------
    public boolean deletePatient(int id) {

        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM Patients WHERE PatientID=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) status = true;

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ---------------- UPDATE PATIENT ----------------
    public boolean updatePatient(int id, String name, int age, String gender,
                                 String date, String ailment, String doctor) {

        boolean status = false;

        try {
            Connection con = DBConnection.getConnection();

            String sql =
                "UPDATE Patients SET PatientName=?, Age=?, Gender=?, AdmissionDate=?, Ailment=?, AssignedDoctor=? " +
                "WHERE PatientID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, date);
            ps.setString(5, ailment);
            ps.setString(6, doctor);
            ps.setInt(7, id);

            int rows = ps.executeUpdate();

            if (rows > 0) status = true;

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // ---------------- REPORT MODULE (MAIN FIXED PART) ----------------
    public List<Patient> getReport(String fromDate, String toDate, String ailment, String doctor) {

        List<Patient> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM Patients WHERE 1=1";

            if (fromDate != null && !fromDate.isEmpty() &&
                toDate != null && !toDate.isEmpty()) {
                sql += " AND AdmissionDate BETWEEN ? AND ?";
            }

            if (ailment != null && !ailment.isEmpty()) {
                sql += " AND Ailment=?";
            }

            if (doctor != null && !doctor.isEmpty()) {
                sql += " AND AssignedDoctor=?";
            }

            PreparedStatement ps = con.prepareStatement(sql);

            int i = 1;

            if (fromDate != null && !fromDate.isEmpty() &&
                toDate != null && !toDate.isEmpty()) {
                ps.setString(i++, fromDate);
                ps.setString(i++, toDate);
            }

            if (ailment != null && !ailment.isEmpty()) {
                ps.setString(i++, ailment);
            }

            if (doctor != null && !doctor.isEmpty()) {
                ps.setString(i++, doctor);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patient p = new Patient();

                p.setPatientID(rs.getInt("PatientID"));
                p.setPatientName(rs.getString("PatientName"));
                p.setAge(rs.getInt("Age"));
                p.setGender(rs.getString("Gender"));
                p.setAdmissionDate(rs.getDate("AdmissionDate"));
                p.setAilment(rs.getString("Ailment"));
                p.setAssignedDoctor(rs.getString("AssignedDoctor"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}