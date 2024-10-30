package dam.moviles.ej4repaso

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import dam.moviles.ej4repaso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicializarBinding()
        inicializarEventos()
    }

    private fun inicializarBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.setContentView(binding.root)
    }

    private fun inicializarEventos(){
        val figuras = arrayOf("Seleccione figura", "Cubo", "Cono", "Cilindro")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, figuras)
        binding.spinnerFiguras.adapter = adapter

        binding.btnSeleccionar.setOnClickListener {
            val figuraSeleccionada = binding.spinnerFiguras.selectedItem.toString()
            mostrarComponentes(figuraSeleccionada)
        }

        binding.btnCalcularArea.setOnClickListener {
            calcularArea()
        }

        binding.btnCalcularVolumen.setOnClickListener {
            calcularVolumen()
        }
    }

    private fun mostrarComponentes(figura: String) {
        hideAllEditTexts()

        when (figura) {
            "Cubo" -> {
                binding.editTextLado.visibility = View.VISIBLE
                binding.imageFigura.setImageResource(R.drawable.ic_cubo)
            }
            "Cono" -> {
                binding.editTextRadio.visibility = View.VISIBLE
                binding.editTextGeneratriz.visibility = View.VISIBLE
                binding.editTextAltura.visibility = View.VISIBLE
                binding.imageFigura.setImageResource(R.drawable.ic_cono)
            }
            "Cilindro" -> {
                binding.editTextRadio.visibility = View.VISIBLE
                binding.editTextAltura.visibility = View.VISIBLE
                binding.imageFigura.setImageResource(R.drawable.ic_cilindro)
            }
        }
        if(figura != "Seleccione figura") {
            binding.imageFigura.visibility = View.VISIBLE
            binding.btnCalcularArea.visibility = View.VISIBLE
            binding.btnCalcularVolumen.visibility = View.VISIBLE
        }
    }

    private fun hideAllEditTexts() {
        binding.editTextLado.visibility = View.GONE
        binding.editTextArea.visibility = View.GONE
        binding.editTextPerimetro.visibility = View.GONE
        binding.editTextAltura.visibility = View.GONE
        binding.editTextApotema.visibility = View.GONE
        binding.editTextRadio.visibility = View.GONE
        binding.editTextGeneratriz.visibility = View.GONE
        binding.imageFigura.visibility = View.GONE
        binding.btnCalcularArea.visibility = View.GONE
        binding.btnCalcularVolumen.visibility = View.GONE
    }

    private fun calcularArea() {
        val figuraSeleccionada = binding.spinnerFiguras.selectedItem.toString()
        val area = when (figuraSeleccionada) {
            "Cubo" -> {
                val ladoStr = binding.editTextLado.text.toString()
                if (ladoStr.isEmpty()) {
                    Snackbar.make(findViewById(android.R.id.content), "Por favor ingrese el lado del cubo", Snackbar.LENGTH_LONG).show()
                    return
                }
                val lado = ladoStr.toDouble()
                Cubo(lado).calcularArea()
            }
            "Cono" -> {
                val radioStr = binding.editTextRadio.text.toString()
                val generatrizStr = binding.editTextGeneratriz.text.toString()
                val alturaStr = binding.editTextAltura.text.toString()
                if (radioStr.isEmpty() || generatrizStr.isEmpty() || alturaStr.isEmpty()) {
                    Snackbar.make(findViewById(android.R.id.content), "Por favor ingrese todos los valores del cono", Snackbar.LENGTH_LONG).show()
                    return
                }
                val radio = radioStr.toDouble()
                val generatriz = generatrizStr.toDouble()
                val altura = alturaStr.toDouble()
                Cono(radio, altura, generatriz).calcularArea()
            }
            "Cilindro" -> {
                val radioStr = binding.editTextRadio.text.toString()
                val alturaStr = binding.editTextAltura.text.toString()
                if (radioStr.isEmpty() || alturaStr.isEmpty()) {
                    Snackbar.make(findViewById(android.R.id.content), "Por favor ingrese todos los valores del cilindro", Snackbar.LENGTH_LONG).show()
                    return
                }
                val radio = radioStr.toDouble()
                val altura = alturaStr.toDouble()
                Cilindro(radio, altura).calcularArea()
            }
            else -> {
                Snackbar.make(findViewById(android.R.id.content), "Seleccione una figura válida", Snackbar.LENGTH_LONG).show()
                return
            }
        }
        Snackbar.make(findViewById(android.R.id.content), "Área: $area", Snackbar.LENGTH_LONG).show()
    }

    private fun calcularVolumen() {
        val figuraSeleccionada = binding.spinnerFiguras.selectedItem.toString()
        val volumen = when (figuraSeleccionada) {
            "Cubo" -> {
                val ladoStr = binding.editTextLado.text.toString()
                if (ladoStr.isEmpty()) {
                    Snackbar.make(findViewById(android.R.id.content), "Por favor ingrese el lado del cubo", Snackbar.LENGTH_LONG).show()
                    return
                }
                val lado = ladoStr.toDouble()
                Cubo(lado).calcularVolumen()
            }
            "Cono" -> {
                val radioStr = binding.editTextRadio.text.toString()
                val generatrizStr = binding.editTextGeneratriz.text.toString()
                val alturaStr = binding.editTextAltura.text.toString()
                if (radioStr.isEmpty() || generatrizStr.isEmpty() || alturaStr.isEmpty()) {
                    Snackbar.make(findViewById(android.R.id.content), "Por favor ingrese todos los valores del cono", Snackbar.LENGTH_LONG).show()
                    return
                }
                val radio = radioStr.toDouble()
                val generatriz = generatrizStr.toDouble()
                val altura = alturaStr.toDouble()
                Cono(radio, altura, generatriz).calcularVolumen()
            }
            "Cilindro" -> {
                val radioStr = binding.editTextRadio.text.toString()
                val alturaStr = binding.editTextAltura.text.toString()
                if (radioStr.isEmpty() || alturaStr.isEmpty()) {
                    Snackbar.make(findViewById(android.R.id.content), "Por favor ingrese todos los valores del cilindro", Snackbar.LENGTH_LONG).show()
                    return
                }
                val radio = radioStr.toDouble()
                val altura = alturaStr.toDouble()
                Cilindro(radio, altura).calcularVolumen()
            }
            else -> {
                Snackbar.make(findViewById(android.R.id.content), "Seleccione una figura válida", Snackbar.LENGTH_LONG).show()
                return
            }
        }
        Snackbar.make(findViewById(android.R.id.content), "Volumen: $volumen", Snackbar.LENGTH_LONG).show()
    }

}
