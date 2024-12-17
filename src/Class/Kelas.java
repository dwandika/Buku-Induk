 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;

/**
 *
 * @author USER
 */
public class Kelas {
    

    String token = "ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49";
    String query,prodi;
    int angkatan;

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    
    
        public JSONObject getKelass(){
        query = "SELECT DISTINCT kelas FROM t_kelas";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
            }
        }
        return obj;
    }

    public JSONObject tampilKelas() {
        query = "SELECT * FROM t_kelas k LEFT JOIN t_prodi p ON k.prodi_id = p.prodi_id WHERE k.deleted = 0 AND p.prodi = '" + prodi + "' AND k.angkatan = "+angkatan+"  ORDER BY k.kelas DESC LIMIT 600";
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=q1399g4dor4strf9b227ojlghp")
                .body("{\"token\":\"" + token + "\",\r\n\"query\":\"" + query + "\"}")
                .asString();

        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
            }
        }
        return obj;
    }
}
