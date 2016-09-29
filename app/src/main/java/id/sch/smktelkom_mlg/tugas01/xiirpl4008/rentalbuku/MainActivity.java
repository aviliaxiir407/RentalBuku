package id.sch.smktelkom_mlg.tugas01.xiirpl4008.rentalbuku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etAlamat, etKtp;
    RadioButton rbSM, rbGM, rbPM;
    RadioGroup rgMember;
    Spinner spJudul;
    CheckBox cbCC, cbBS, cbPB;
    Button bOk;
    TextView tvHasilsp, tvHasilcb, tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        etKtp = (EditText) findViewById(R.id.editTextKtp);

        bOk = (Button) findViewById(R.id.buttonOk);
        rbSM = (RadioButton) findViewById(R.id.radioButtonSM);
        rbGM = (RadioButton) findViewById(R.id.radioButtonGM);
        rbPM = (RadioButton) findViewById(R.id.radioButtonPM);

        rgMember = (RadioGroup) findViewById(R.id.radioGroupMember);

        spJudul = (Spinner) findViewById(R.id.spinnerJudul);

        cbCC = (CheckBox) findViewById(R.id.checkBoxCC);
        cbBS = (CheckBox) findViewById(R.id.checkBoxBS);
        cbPB = (CheckBox) findViewById(R.id.checkBoxPB);

        tvHasilsp = (TextView) findViewById(R.id.textViewHasil);
        tvHasilcb = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil = (TextView) findViewById(R.id.textViewHasil3);

        findViewById(R.id.buttonOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });

        /*bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });*/
    }

    private void doClick() {

        int diskon = 0;
        RadioButton rb = (RadioButton)
                findViewById(rgMember.getCheckedRadioButtonId());
        if (rb.getText().toString().equals("Silver Member")) diskon = 10;
        else if (rb.getText().toString().equals("Gold Member")) diskon = 20;
        else diskon = 30;

        if (isValid()) {
            String nama = etNama.getText().toString();
            String alamat = etAlamat.getText().toString();
            String ktp = etKtp.getText().toString();

            tvHasil.setText("Nama : " + nama + "\n Alamat : " + alamat + "\n No Ktp : " + ktp);
        }


        StringBuilder builder = new StringBuilder();
        builder.append("Nama : ");
        builder.append(etNama.getText().toString() + "\n");
        builder.append("Alamat : ");
        builder.append(etAlamat.getText().toString() + "\n");
        builder.append("No. Ktp : ");
        builder.append(etKtp.getText().toString() + "\n");
        builder.append("Member : ");
        builder.append(rb.getText().toString() + "\n");
        builder.append("Judul Buku : ");
        builder.append(tvHasilsp.getText().toString() + "\n");
        builder.append("Judul Buku : ");
        builder.append(tvHasilsp.getText().toString() + "\n");
        builder.append("Kondisi Pinjam : ");
        builder.append(tvHasilcb.getText().toString() + "\n");

        tvHasil.setText(builder);

        /* if(rb.gtText().toString().equals("member")) diskon = 10;
         * else if */

        String hasilrb = null;

        if (rbSM.isChecked()) {
            hasilrb = rbSM.getText().toString();
        } else if (rbGM.isChecked()) {
            hasilrb = rbGM.getText().toString();
        } else if (rbPM.isChecked()) {
            hasilrb = rbPM.getText().toString();
        }

        /*if (hasilrb == null) {
            tvHasil.setText("Belum Menjadi Member");
        } else {
            tvHasil.setText("\n Member Anda : " + hasilrb + "\n");
        }

        /*tvHasil.setText("Judul Buku : " + spJudul.getSelectedItem().toString() + "\n");*/

        String hasilcb = "Kondisi Buku Pinjam : \n";
        int startlen = hasilcb.length();
        if (cbCC.isChecked()) hasilcb += cbCC.getText() + "\n";
        if (cbBS.isChecked()) hasilcb += cbBS.getText() + "\n";
        if (cbPB.isChecked()) hasilcb += cbPB.getText() + "\n";

        if (hasilcb.length() == startlen) hasilcb += "Tidak Meminjam Buku";

        tvHasilcb.setText(hasilcb);
    }


    private void doProcess() {


    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        String ktp = etKtp.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Belum diisi");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Belum Diisi");
            valid = false;
        } else {
            etAlamat.setError(null);
        }

        if (ktp.isEmpty()) {
            etKtp.setError("Belum Diisi");
            valid = false;
        } else if (ktp.length() != 16) {
            etKtp.setError("Masukkan 16 Digit");
            valid = false;
        } else {
            etKtp.setError(null);
        }
        return valid;
    }


}
