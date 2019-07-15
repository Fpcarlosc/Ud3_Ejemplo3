# Ud3_Ejemplo3
_Ejemplo 3 de la Unidad 3._

Creamos _Intents_ explícitos y abrimos varias actividades al igual que en [Ud2_Ejemplo2](https://github.com/Fpcarlosc/Ud3_Ejemplo2) pero en este caso no hacemos uso del 
atributo _onClick_ en los _TextViews_ sino que utilizamos _onClickListener_.

Los pasos a seguir son parecidos al ejemplo anterior:

## Paso 1: Creación de los layouts

Primero creamos el layout de la Actividad principal en el fichero _activity_main.xml_:
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/actividad1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/holo_blue_dark"
        android:padding="16dp"
        android:text="@string/actividad_1"
        android:textColor="@android:color/white" />

    <TextView
        android:id="@+id/actividad2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/holo_green_dark"
        android:padding="16dp"
        android:text="@string/actividad_2"
        android:textColor="@android:color/white" />

</LinearLayout>
```
En él creamos dos TextView que al pulsarlos abrirán las actividades. Notad que no está el atributo _onClick_ y que cada
_TextView_ tiene su _id_ asociado, esto es necesario para posteriormente poder buscarlo y asignarle el _Click Listener_.

Después creamos los layouts de las dos actividades. Para crearlos creamos dos nuevos _Layout resource files_ dentro de la carpeta values:

_actividad1.xml_:
```
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/actividad_1"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```
y _actividad2.xml_:
```
<android.support.constraint.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/actividad_2"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</android.support.constraint.ConstraintLayout>
```
## Paso 2: Creación de las actividades
Ahora vamos a crear las actividades, para ello creamos dos clases Java que extiendan de la clase _AppCompatActivity_ y sobreescriban el método _onCreate_. En él se cargará el layout de la actividad usando el método _setContentView_ y accediendo a él a través de la clase _R_.

_Actividad1.java_:
```
public class Actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad1);
    }
}
```
_Actividad2.java_:
```
public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);
    }
}
```
## Paso 3: Asignación de los _Click Listeners_ a los _TextView_
El siguiente paso es modificar la clase _MainActivity.java_ y asignar a los dos _TextView_ de nuestra aplicación los
_Click Listeners_. Para ello hay que hacer:
1. Buscar el _TextView_ pr su _id_ haciendo uso del método _findViewById_.
2. Asignar el _Click Listener_ sobre ese _TextView_.
3. Crear el _Intent_ dentro del método sobreescrito _onClick_.

_MainActivity.java_:
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscamos el TextView de la actividad 1 por su id (actividad1).
        TextView actividad1 = findViewById(R.id.actividad1);

        // Asignamos un Click Listener sobre el TextView
        actividad1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct1 = new Intent(MainActivity.this, Actividad1.class);
                startActivity(intentAct1);
            }
        });

        // Buscamos el TextView de la actividad 2 por su id (actividad2).
        TextView actividad2 = findViewById(R.id.actividad2);

        // Asignamos un Click Listener sobre el TextView
        actividad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAct2 = new Intent(MainActivity.this, Actividad2.class);
                startActivity(intentAct2);
            }
        });
    }
}
```
## Paso 4: Inserción de las actividades en el fichero AndroidManifest.xml
Por último, tenemos que indicarle al fichero _AndroidManifest.xml_ que las nuevas actividades existen y tienen como actividad padre a _MainActivity.java_. 
Para ello añadimos las siguientes líneas:
```
...
        <activity
            android:name=".Actividad1"
            android:label="@string/actividad_1"
            android:parentActivityName=".MainActivity">
        </activity>
        <activity
            android:name=".Actividad2"
            android:label="@string/actividad_2"
            android:parentActivityName=".MainActivity">
        </activity>
    </application>
</manifest>
```
