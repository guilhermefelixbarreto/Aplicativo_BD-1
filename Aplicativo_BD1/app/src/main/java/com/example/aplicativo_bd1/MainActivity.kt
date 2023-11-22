package com.example.aplicativo_bd1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aplicativo_bd1.db.DBHandler
import com.example.aplicativo_bd1.ui.theme.Aplicativo_BD1Theme
import com.example.aplicativo_bd1.ui.theme.PurpleGrey40


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.M)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aplicativo_BD1Theme {
                Surface(
                    // on below line we are specifying modifier and color for our app
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

                    // on the below line we are specifying the theme as the scaffold.
                    Scaffold(

                        // in scaffold we are specifying the top bar.
                        topBar = {

                            // inside top bar we are specifying background color.
                            TopAppBar(colors = TopAppBarDefaults.centerAlignedTopAppBarColors(),

                                // along with that we are specifying title for our top bar.
                                title = {

                                    // in the top bar we are specifying tile as a text
                                    Text(
                                        // on below line we are specifying
                                        // text to display in top app bar.
                                        text = "GFG",

                                        // on below line we are specifying
                                        // modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // on below line we are specifying
                                        // text alignment.
                                        textAlign = TextAlign.Center,

                                        // on below line we are specifying
                                        // color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {
                        // on below line we are calling our method to display UI
                        addDataToDatabase(LocalContext.current)
                    }
                }
            }
        }
    }
}

// on below line we are creating battery status function.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun addDataToDatabase(
    context: Context
) {

    val activity = context as Activity
    // on below line creating a variable for battery status
    val Name= remember {
        mutableStateOf(TextFieldValue())
    }
    val ENDERECO = remember {
        mutableStateOf(TextFieldValue())
    }
    val BAIRRO = remember {
        mutableStateOf(TextFieldValue())
    }
    val CEP = remember {
        mutableStateOf(TextFieldValue())
    }
    val CIDADE = remember {
        mutableStateOf(TextFieldValue())
    }
    val ESTADO = remember {
        mutableStateOf(TextFieldValue())
    }
    val TELEFONE = remember {
        mutableStateOf(TextFieldValue())
    }
    val CELULAR = remember {
        mutableStateOf(TextFieldValue())
    }


    // on below line we are creating a column,
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        var dbHandler: DBHandler = DBHandler(context)

        // on below line we are adding a text for heading.
        Text(
            // on below line we are specifying text
            text = "SQlite Banco de Dados no AndroidStudio",
            // on below line we are specifying text color, font size and font weight
            color = PurpleGrey40, fontSize = 20.sp, fontWeight = FontWeight.Bold
        )

        // on below line adding a spacer.
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = Name.value,
            // on below line we are adding on value change for text field.
            onValueChange = { Name.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Adicione o seu Nome") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = ENDERECO.value,
            // on below line we are adding on value change for text field.
            onValueChange = { ENDERECO.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Adicione seu Endereço") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))


        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = BAIRRO.value,
            // on below line we are adding on value change for text field.
            onValueChange = { BAIRRO.value = it },
            // on below line we are adding place holder as text
            placeholder = { Text(text = "Adicione o seu Bairro") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = CEP.value,
            // on below line we are adding on value change for text field.
            onValueChange = { CEP.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Adicione o seu CEP") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            // on below line we are specifying value for our email text field.
            value = CIDADE.value,
            // on below line we are adding on value change for text field.
            onValueChange = { CIDADE.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Adicione o sua Cidade") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            // on below line we are specifying value for our email text field.
            value = ESTADO.value,
            // on below line we are adding on value change for text field.
            onValueChange = { ESTADO.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Adicione o seu Estado") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            // on below line we are specifying value for our email text field.
            value = TELEFONE.value,
            // on below line we are adding on value change for text field.
            onValueChange = { TELEFONE.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Adicione o seu Telefone") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            // on below line we are specifying value for our email text field.
            value = CELULAR.value,
            // on below line we are adding on value change for text field.
            onValueChange = { CELULAR.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Adicione o seu número de Celular") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth(),
            // on below line we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(15.dp))

        // on below line creating a button to check battery charging status
        Button(
            onClick = {
                dbHandler.addNewCourse(
                    Name.value.text,
                    ENDERECO.value.text,
                    BAIRRO.value.text,
                    CEP.value.text,
                    CIDADE.value.text,
                    ESTADO.value.text,
                    TELEFONE.value.text,
                    CELULAR.value.text
                )
                Toast.makeText(context, "Informações Adionadas no Banco de Dados", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Adicione os Campos para o Banco de Dados", color = Color.White)
        }

        // Botão Visualizar
        Button(
            onClick = {
                val i = Intent(context, ViewCourses::class.java)
                context.startActivity(i)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(imageVector = Icons.Default.List, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Visualizar Todas as Informações Enviadas", color = Color.White)
        }
    }
}
