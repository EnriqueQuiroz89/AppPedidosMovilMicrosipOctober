package example.javatpoint.com.apppedidosmovilmicrosip.FakeDataToDB

import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Articulos
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Clientes
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.PartidaPedido
import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Pedidos
import java.util.*
import kotlin.collections.ArrayList

class FillTablesDataFake {

    lateinit var listaClientes: ArrayList<Clientes>

    lateinit var listaArticulos: ArrayList<Articulos>

    lateinit var listaPedidos: ArrayList<Pedidos>

    lateinit var listaPartidas: ArrayList<PartidaPedido>

    lateinit var listaPartidasUno: ArrayList<PartidaPedido>
    lateinit var listaPartidasDos: ArrayList<PartidaPedido>
    lateinit var listaPartidasTres: ArrayList<PartidaPedido>
    lateinit var listaPartidasCuatro: ArrayList<PartidaPedido>
    lateinit var listaPartidasCinco: ArrayList<PartidaPedido>



    fun fillListaClientes(): ArrayList<Clientes> {

        listaClientes = ArrayList()

        listaClientes.add(
            Clientes(
                1,
                "Raul Ibañes",
                3295,
                1234,
                "2324",
                "Prolongacion Galeana",
                "Ixtapa",
                "Cerrillo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                2,
                "Giovany Peralta",
                3295,
                1234,
                "9873",
                "Rioacha Salamanca",
                "Zacango",
                "Crespa",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                3,
                "Francisco Peña",
                3295,
                1234,
                "3333",
                "Perriferica sur vallejo",
                "Lerma",
                "Tomasquillo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                4,
                "MAteo Quiroz",
                3295,
                1234,
                "9879",
                "Etiopia y revolucion",
                "Ixtaln",
                "Hidalgo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                5,
                "Saul Ramires",
                3295,
                1234,
                "5465",
                "Genral MArtinez Pliego",
                "Tehotihuacan",
                "Ensenada",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                6,
                "Leonel Mesis",
                3295,
                1234,
                "5454",
                "General Villada Lopez",
                "San Pedro",
                "Tlazcala",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                7,
                "Rick MOntana",
                3295,
                1234,
                "5456",
                "Herminio Gonzalez",
                "Rio Janeiro",
                "Villa Flores",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                8,
                "Gerardo Peña",
                3295,
                1234,
                "5646",
                "Sor Juana Inez Cruz",
                "Laredo Tam",
                "Geo Laredo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                9,
                "Leandro VAlle",
                3295,
                1234,
                "2324",
                "Prolongacion Galeana",
                "Ixtapa",
                "Cerrillo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                10,
                "Raul Montana",
                3295,
                1234,
                "7398",
                "Rioacha Salamanca",
                "Zacango",
                "Crespa",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                11,
                "Arcadio Buendia",
                3295,
                1234,
                "3329",
                "Perriferica sur vallejo",
                "Lerma",
                "Tomasquillo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                12,
                "Sergio Castrejon",
                3295,
                1234,
                "9857",
                "Etiopia y revolucion",
                "Ixtaln",
                "Hidalgo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                13,
                "MArio Peña",
                3295,
                1234,
                "5445",
                "Genral MArtinez Pliego",
                "Tehotihuacan",
                "Ensenada",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                14,
                "Laura Medina",
                3295,
                1234,
                "9875",
                "General Villada Lopez",
                "San Pedro",
                "Tlazcala",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                15,
                "Johana Alvirde",
                3295,
                1234,
                "3656",
                "Herminio Gonzalez",
                "Rio Janeiro",
                "Villa Flores",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                16,
                "Gerardo Rosales",
                3295,
                1234,
                "8751",
                "Sor Juana Inez Cruz",
                "Laredo Tam",
                "Geo Laredo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                17,
                "Tiago Silva",
                3295,
                1234,
                "6354",
                "Prolongacion Galeana",
                "Ixtapa",
                "Cerrillo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                18,
                "Diego Cortua",
                3295,
                1234,
                "6546",
                "Rioacha Salamanca",
                "Zacango",
                "Crespa",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                19,
                "Franciso Lopez",
                3295,
                1234,
                "5465",
                "Perriferica sur vallejo",
                "Lerma",
                "Tomasquillo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                20,
                "Genaro Garcia",
                3295,
                1234,
                "6565",
                "Etiopia y revolucion",
                "Ixtaln",
                "Hidalgo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                21,
                "Santos Medina",
                3295,
                1234,
                "6555",
                "Genral MArtinez Pliego",
                "Tehotihuacan",
                "Ensenada",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                22,
                "Luigi MArio",
                3295,
                1234,
                "5245",
                "General Villada Lopez",
                "San Pedro",
                "Tlazcala",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                23,
                "Ernesto Cedillo",
                3295,
                1234,
                "6354",
                "Herminio Gonzalez",
                "Rio Janeiro",
                "Villa Flores",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                24,
                "Santos Bris",
                3295,
                1234,
                "3654",
                "Sor Juana Inez Cruz",
                "Laredo Tam",
                "Geo Laredo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                25,
                "Adela Monrroy",
                3295,
                1234,
                "6365",
                "Prolongacion Galeana",
                "Ixtapa",
                "Cerrillo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                26,
                "Jose Fernandez",
                3295,
                1234,
                "5685",
                "Rioacha Salamanca",
                "Zacango",
                "Crespa",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                27,
                "Luis Medina",
                3295,
                1234,
                "3523",
                "Perriferica sur vallejo",
                "Lerma",
                "Tomasquillo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                28,
                "Felipe Salinas",
                3295,
                1234,
                "3659",
                "Etiopia y revolucion",
                "Ixtaln",
                "Hidalgo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                29,
                "Roroteo Arango",
                3295,
                1234,
                "6564",
                "Genral MArtinez Pliego",
                "Tehotihuacan",
                "Ensenada",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                30,
                "Shakira Madrid",
                3295,
                1234,
                "5664",
                "General Villada Lopez",
                "San Pedro",
                "Tlazcala",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                31,
                "Josefa Ceballos",
                3295,
                1234,
                "5476",
                "Herminio Gonzalez",
                "Rio Janeiro",
                "Villa Flores",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )
        listaClientes.add(
            Clientes(
                32,
                "Lou Vega",
                3295,
                1234,
                "3546",
                "Sor Juana Inez Cruz",
                "Laredo Tam",
                "Geo Laredo",
                2345.542,
                1234.5,
                123.123,
                987.987
            )
        )

        return listaClientes

    }


    fun fillListaArticulos(): ArrayList<Articulos> {

        listaArticulos = ArrayList()
        listaArticulos.add(
            Articulos(
                3756,
                "B29119",
                "PLTIN",
                "Tinaco de 1100 litros",
                2345.43,
                16.01,
                336.00
            )
        )
        listaArticulos.add(
            Articulos(
                2831,
                "B58046",
                "AL_58046",
                "CONTAC. DUPLEX C/PLACA DORADO/MARFIL",
                930.00,
                16.01,
                298.00
            )
        )
        listaArticulos.add(
            Articulos(
                3036,
                "B58044",
                "AL_58044",
                "AMANCO HID ANGER COPLE REPARACION  8",
                473.00,
                16.01,
                463.00
            )
        )
        listaArticulos.add(
            Articulos(
                3215,
                "B58043",
                "AL_58043",
                "IGOTO Contacto duplex con placa negro/blanc",
                354.00,
                16.01,
                754.00
            )
        )
        listaArticulos.add(
            Articulos(
                2072,
                "B58042",
                "AL_58042",
                "IGOTO Contacto duplex con placa dorado/blan",
                440.00,
                16.01,
                91.00
            )
        )
        listaArticulos.add(
            Articulos(
                2687,
                "B58041",
                "AL_58041",
                "ROTOPLAS REGISTRO PARA LODO",
                483.00,
                16.01,
                403.00
            )
        )
        listaArticulos.add(
            Articulos(
                3746,
                "B58040",
                "AL_58040",
                "LLAVERO MULTIMARCA",
                753.00,
                16.01,
                339.00
            )
        )
        listaArticulos.add(
            Articulos(
                2024,
                "B58018",
                "AL_58018",
                "DURMAN GAS TUBO DG PE-AL-PE 3/8 X 100MTS ",
                809.00,
                16.01,
                56.00
            )
        )
        listaArticulos.add(
            Articulos(
                3898,
                "B58015",
                "AL_58015",
                "DORUS J39 GALON  4KG",
                337.00,
                16.01,
                696.00
            )
        )
        listaArticulos.add(
            Articulos(
                2380,
                "B58014",
                "AL_58014",
                "MANOMETRO ALTAMIRA GLICEERINA 0-100 PSI 1/4",
                128.00,
                16.01,
                823.00
            )
        )
        listaArticulos.add(
            Articulos(
                3658,
                "B58013",
                "AL_58013",
                "DURMAN TUBO XPA AZUL PE AL PE 1/2",
                510.00,
                16.01,
                174.00
            )
        )
        listaArticulos.add(
            Articulos(
                3946,
                "B58012",
                "AL_58012",
                "AMANCO HID CEM RED BUSHING C-40 100X60MM",
                574.00,
                16.01,
                386.00
            )
        )
        listaArticulos.add(
            Articulos(
                3839,
                "B58010",
                "AL_58010",
                "AMANCO HID CEM CRUZ C-40 100MM",
                919.00,
                16.01,
                499.00
            )
        )
        listaArticulos.add(
            Articulos(
                2293,
                "B58009",
                "AL_58009",
                "DURMAN GAS  COPLE SIS/COMP LATON  1/2",
                796.00,
                16.01,
                854.00
            )
        )
        listaArticulos.add(
            Articulos(
                3185,
                "B58007",
                "AL_58007",
                "TORNILLO FO-FO CON TUERCA",
                712.00,
                16.01,
                93.00
            )
        )
        listaArticulos.add(
            Articulos(
                3536,
                "B58006",
                "AL_58006",
                "EMPAQUE BRIDA PVC HID 100M",
                226.00,
                16.01,
                122.00
            )
        )
        listaArticulos.add(
            Articulos(
                2048,
                "B58005",
                "AL_58005",
                "EMPAQUE BRIDA PVC HID 75MM",
                389.00,
                16.01,
                51.00
            )
        )
        listaArticulos.add(
            Articulos(
                2608,
                "B58004",
                "AL_58004",
                "EXTREMIDAD ESPIGA PVC HID 100 MM",
                654.00,
                16.01,
                15.00
            )
        )
        listaArticulos.add(
            Articulos(
                3391,
                "B58003",
                "AL_58003",
                "EXTREMIDAD ESPIGA PVC HID 74MM",
                378.00,
                16.01,
                503.00
            )
        )
        listaArticulos.add(
            Articulos(
                3981,
                "B58002",
                "AL_58002",
                "EXTREMIDAD CAMPANA PVC HID RIEBBER 100M",
                562.00,
                16.01,
                665.00
            )
        )
        listaArticulos.add(
            Articulos(
                2952,
                "B58001",
                "AL_58001",
                "EXTREMIDAD CAMPANA PVC HID RIEBBER 75MM",
                360.00,
                16.01,
                137.00
            )
        )
        listaArticulos.add(
            Articulos(
                3359,
                "B58000",
                "AL_58000",
                "VALVULA COMP. FO-FO V FIJO O-RING 101MM",
                630.00,
                16.01,
                128.00
            )
        )
        listaArticulos.add(
            Articulos(
                2593,
                "B54390",
                "AL_54390",
                "VALVULA COMP. FO-FO V/FIJO O-RING 76 MM",
                629.00,
                16.01,
                461.00
            )
        )
        listaArticulos.add(
            Articulos(
                2280,
                "B54380",
                "AL_54380",
                "IUSA TERM P/BASE WATTHOMETRO EMP81  310903",
                699.00,
                16.01,
                534.00
            )
        )
        listaArticulos.add(
            Articulos(
                3294,
                "B54370",
                "AL_54370",
                "DICA VOLANTE ARAÑA DE 8-1/4      R444050",
                223.00,
                16.01,
                369.00
            )
        )
        listaArticulos.add(
            Articulos(
                2551,
                "B54360",
                "AL_54360",
                "DICA MONO P/REG O TINA SENCILLO YAS CRO 681YZ",
                535.00,
                16.01,
                662.00
            )
        )
        listaArticulos.add(
            Articulos(
                2043,
                "B54350",
                "AL_54350",
                "FLEXIMATIC CESPOL PRACTICO FLEXIBLE 1 1/4 TIPO  EXT 80 CM P/LAVABO 2931",
                470.00,
                16.01,
                477.00
            )
        )
        listaArticulos.add(
            Articulos(
                2504,
                "B54340",
                "AL_54340",
                "DICA REG DE PLATO 8",
                4538.0,
                16.0,
                16.01
            )
        )
        listaArticulos.add(
            Articulos(
                3165,
                "B54330",
                "AL_54330",
                "FLEXIMATIC JGO HERRAJES C/PUSH BOTON SUPERIOR 2724 P",
                108.00,
                16.01,
                468.00
            )
        )
        listaArticulos.add(
            Articulos(
                3511,
                "B54315",
                "AL_54315",
                "ESPREA CORONA 1/4 ",
                193.00,
                16.01,
                604.00
            )
        )
        listaArticulos.add(
            Articulos(
                2822,
                "B54314",
                "AL_54314",
                "CAMPANA ORION 80 PURIF GRIS METALICO  CA ORI-080-P-GM SANAIRE",
                598.00,
                16.01,
                340.00
            )
        )
        listaArticulos.add(
            Articulos(
                3254,
                "B54313",
                "AL_54313",
                "CAMPANA ORION 80 PURIF BLANCA  CA ORI-080-P-BL SANAIRE",
                207.00,
                16.01,
                247.00
            )
        )
        listaArticulos.add(
            Articulos(
                3277,
                "B54312",
                "AL_54312",
                "CAMPANA ORION 80 PURIF NEGRA  CA ORI-080-P-NE SANAIRE",
                725.00,
                16.01,
                828.00
            )
        )
        listaArticulos.add(
            Articulos(
                2083,
                "B54311",
                "AL_54311",
                "CAMPANA ORION 76 PURIF GRIS METALICO  CA ORI-076-P-GM SANAIRE",
                699.00,
                16.01,
                442.00
            )
        )
        listaArticulos.add(
            Articulos(
                2944,
                "B54310",
                "AL_54310",
                "CAMPANA ORION 76 PURIF BLANCA  CA ORI-076-P-BL SANAIRE",
                383.00,
                16.01,
                216.00
            )
        )
        listaArticulos.add(
            Articulos(
                2358,
                "B54309",
                "AL_54309",
                "CAMPANA ORION 76 PURIF NEGRA  CA ORI-076-P-NE SANAIRE",
                486.00,
                16.01,
                374.00
            )
        )
        listaArticulos.add(
            Articulos(
                2399,
                "B54308",
                "AL_54308",
                "CAMPANA AXR 50 PURIF GRIS METLICO  CA AXR-050-P-GM SANAIRE",
                254.00,
                16.01,
                503.00
            )
        )
        listaArticulos.add(
            Articulos(
                2297,
                "B54307",
                "AL_54307",
                "CAMPANA AXR 50 PURIF BLANCA  CA AXR-050-P-BL SANAIRE",
                535.00,
                16.01,
                723.00
            )
        )
        listaArticulos.add(
            Articulos(
                2994,
                "B54306",
                "AL_54306",
                "CAMPANA AXR 50 PURIF NEGRA  CA AXR-050-P-NE SANAIRE",
                601.00,
                16.01,
                164.00
            )
        )
        listaArticulos.add(
            Articulos(
                3766,
                "B54305",
                "AL_54305",
                "CAMPANA AXR 80 PURIF GRIS METALICO  CA AXR-080-P-GM SANAIRE",
                568.00,
                16.01,
                189.00
            )
        )
        listaArticulos.add(
            Articulos(
                3449,
                "B54304",
                "AL_54304",
                "CAMPANA AXR 80 PURIF BLANCA  CA AXR-080-P-BL SANAIRE",
                644.00,
                16.01,
                138.00
            )
        )
        listaArticulos.add(
            Articulos(
                2342,
                "B54303",
                "AL_54303",
                "CAMPANA AXR 80 PURIF NEGRA  CA AXR-080-P-NE SANAIRE",
                178.00,
                16.01,
                453.00
            )
        )
        listaArticulos.add(
            Articulos(
                3659,
                "B54302",
                "AL_54302",
                "CAMPANA AXR 76 PURIF GRIS METALICO  CA AXR-076-P-GM SANAIRE",
                551.00,
                16.01,
                151.00
            )
        )
        listaArticulos.add(
            Articulos(
                2503,
                "B54301",
                "AL_54301",
                "CAMPANA AXR 76 PURIF BLANCA  CA AXR-076-P-BL SANAIRE",
                937.00,
                16.01,
                560.00
            )
        )
        listaArticulos.add(
            Articulos(
                3687,
                "B54300",
                "AL_54300",
                "CAMPANA AXR 76 PURIF NEGRA  CA AXR-076-P-NE SANAIRE",
                966.00,
                16.01,
                858.00
            )
        )
        listaArticulos.add(
            Articulos(
                3668,
                "B54280",
                "AL_54280",
                "PENS POLICARBONATO TRASP. CARTUCHO SSI10T30",
                797.00,
                16.01,
                786.00
            )
        )
        listaArticulos.add(
            Articulos(
                2262,
                "B54279",
                "AL_54279",
                "HELVEX LLAVE DE LAVABO ECONOMIZADORA INSTITUCIONAL CROMO",
                832.00,
                16.01,
                486.00
            )
        )
        listaArticulos.add(
            Articulos(
                2982,
                "B54278",
                "AL_54278",
                "HELVEX EMBOLO ARMADO P/FLUXOMETRO 6LTS",
                561.00,
                16.01,
                100.00
            )
        )
        listaArticulos.add(
            Articulos(
                2994,
                "B54277",
                "AL_54277",
                "HELVEX CUERPO ESTOPERO C/CUERDA P/FLUXOMETRO RF-230",
                533.00,
                16.01,
                243.00
            )
        )
        listaArticulos.add(
            Articulos(
                3641,
                "B54276",
                "AL_54276",
                "URREA LLAVE ANGULAR OVAL  3401SCE",
                833.00,
                16.01,
                794.00
            )
        )
        listaArticulos.add(
            Articulos(
                2892,
                "B54275",
                "AL_54275",
                "FORZA PLACA CIEGA CON  PRERUPTURA",
                868.00,
                16.01,
                215.00
            )
        )
        listaArticulos.add(
            Articulos(
                3722,
                "B54273",
                "AL_54273",
                "BTICINO CINTA DE AISLAR 19mm x 5 m",
                318.00,
                16.01,
                864.00
            )
        )
        listaArticulos.add(
            Articulos(
                3760,
                "B54272",
                "AL_54272",
                "FORZA PLACA CON TOMA DE T.V TIPO F",
                340.00,
                16.01,
                876.00
            )
        )
        listaArticulos.add(
            Articulos(
                3460,
                "B54271",
                "AL_54271",
                "FORZA PLACA CON TOMA DE TELEFONO RJ11 4 HILOS",
                854.00,
                16.01,
                304.00
            )
        )
        listaArticulos.add(
            Articulos(
                3963,
                "B54270",
                "AL_54270",
                "FORZA PLACA CON ZUMBADOR TIPO D127V 77db",
                715.00,
                16.01,
                77.00
            )
        )
        listaArticulos.add(
            Articulos(
                3822,
                "B54269",
                "AL_54269",
                "FORZA PLACA CON PULSADOR / TIMBRE 10 A 127V",
                278.00,
                16.01,
                392.00
            )
        )
        listaArticulos.add(
            Articulos(
                3502,
                "B54268",
                "AL_54268",
                "FORZA PLACA 2 CONTAC C/PROTECCION INFANTIL + ICFT ",
                243.00,
                16.01,
                889.00
            )
        )

        return listaArticulos

    }

    fun fillListaPedidos(): ArrayList<Pedidos> {

        listaPedidos = ArrayList()
        listaPedidos.add(
            Pedidos(1,
                  1,
                fillListaPartidasDos())
                        )

        listaPedidos.add(
            Pedidos(2,
                   2,
                fillListaPartidasDos()
            )
        )

/*
        //Se llena con datos de otro metodo de la misma clase
        var listaPartidas = fillListaPartidasPedido()
        var listaPartidasUno = fillListaPartidasUno()
        var listaPartidasDos = fillListaPartidasDos()
        var listaPartidasTres = fillListaPartidasTres()
        var listaPartidasCuatro = fillListaPartidasCuatro()
        var listaPartidasCinco = fillListaPartidasCinco()

        listaPedidos = ArrayList()
        listaPedidos.add(
            Pedidos(1,
                "YA2346",
              1212,
                //  Date(2020, 2, 13, 5, 1, 0),
                "Truper",
                1456.04,
                16.0,
                3295,
                "Moises Pulido",
                4562,
                "Ramiro Peña",
                 "Pendiente",
                1,
                listaPartidas
            )
        )
        listaPedidos.add(
            Pedidos(2,
                "YA2347",
               1212,
                // Date(2020, 2, 13, 5, 1, 0),
                "Truper",
                1456.04,
                16.0,
                3295,
                "Moises Pulido",
                4562,
                "Ramiro Peña",
                "Pendiente",
                2,
                listaPartidasUno
            )
        )
        listaPedidos.add(
            Pedidos(3,
                "MP2345",
           1212,
                //     Date(2020, 2, 13, 5, 1, 0),
                "Truper",
                1456.04,
                16.0,
                3295,
                "Moises Pulido",
                4562,
                "Ramiro Peña",
                "Pendiente",
                3,
                listaPartidasDos
            )
        )
        listaPedidos.add(
            Pedidos(4,
                "SG2345",
                1212,
                //Date(2020, 2, 13, 5, 1, 0),
                "Barbado",
                1456.04,
                16.0,
                3295,
                "Moises Pulido",
                4562,
                "Ramiro Peña",
                "Pendiente",
                4,
                listaPartidasTres
            )
        )
        listaPedidos.add(
            Pedidos(5,
                "LU2345",
                1212,
             //    Date(2020, 2, 13, 5, 1, 0),
                "Truper",
                1456.04,
                16.0,
                3295,
                "Moises Pulido",
                4562,
                "Ramiro Peña",
                "Pendiente",
                5,
                listaPartidasCuatro
            )
        )
        listaPedidos.add(
            Pedidos(6,
                "TW2345",
               1212,
               // Date(2020, 2, 13, 5, 1, 0),
       "Barbado",
                1456.04,
                16.0,
                3295,
                "Moises Pulido",
                4562,
                "Ramiro Peña",
                "Pendiente",
                6,
                listaPartidasCinco
            )
        )
        listaPedidos.add(
            Pedidos(7,
                "YA2399",
                1212,
              //  Date(2020, 2, 13, 5, 1, 0),
                "Truper",
                1456.04,
                16.0,
                3295,
                "Moises Pulido",
                4562,
                "Ramiro Peña",
                "Pendiente",
                7,
                listaPartidasUno
            )
        )
*/
        return listaPedidos

                                                }



    fun fillListaPartidasUno(): ArrayList<PartidaPedido> {

        listaPartidasUno = ArrayList()

        listaPartidasUno.add(
PartidaPedido(3250,1234,"B29119","Garrafon de Thiner",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasUno.add(
PartidaPedido(3250,1234,"B29200","Garrafon de Agua",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasUno.add(
PartidaPedido(3250,1234,"B29300","Papas Sabrita",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasUno.add(
PartidaPedido(3250,1234,"B29400","Chocorroles",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasUno.add(
PartidaPedido(3250,1234,"B29500","Galletas MArias",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))

      return listaPartidasUno                           }


    fun fillListaPartidasDos(): ArrayList<PartidaPedido> {

        listaPartidasDos = ArrayList()

        listaPartidasDos.add(
            PartidaPedido(3250,1234,"B29119","Pure de tomate",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasDos.add(
            PartidaPedido(3250,1234,"B29200","Cheto morados",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasDos.add(
            PartidaPedido(3250,1234,"B29300","Tacos de ruleta",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasDos.add(
            PartidaPedido(3250,1234,"B29400","Chicharron de cerdo",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasDos.add(
            PartidaPedido(3250,1234,"B29500","Amanco HID cementar",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))

        return listaPartidasDos                           }


    fun fillListaPartidasTres(): ArrayList<PartidaPedido> {

        listaPartidasTres = ArrayList()

        listaPartidasTres.add(
            PartidaPedido(3250,1234,"B29119","Rotoplas 10010",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasTres.add(
            PartidaPedido(3250,1234,"B29200","AIO Acer",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasTres.add(
            PartidaPedido(3250,1234,"B29300","Frijoles de lata",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasTres.add(
            PartidaPedido(3250,1234,"B29400","No Break Asus",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasTres.add(
            PartidaPedido(3250,1234,"B29500","Churrumais",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))

        return listaPartidasTres                           }



    fun fillListaPartidasCuatro(): ArrayList<PartidaPedido> {

        listaPartidasCuatro = ArrayList()

        listaPartidasCuatro.add(
            PartidaPedido(3250,1234,"B29119","Jamon de pavo",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasCuatro.add(
            PartidaPedido(3250,1234,"B29200","Espuma de poliruetano",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasCuatro.add(
            PartidaPedido(3250,1234,"B29300","Vidrio por kilo",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasCuatro.add(
            PartidaPedido(3250,1234,"B29400","Hipolin Verde",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasCuatro.add(
            PartidaPedido(3250,1234,"B29500","Jamon Serrano",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))

        return listaPartidasCuatro                           }



    fun fillListaPartidasCinco(): ArrayList<PartidaPedido> {

        listaPartidasCinco = ArrayList()

        listaPartidasCinco.add(
            PartidaPedido(3250,1234,"B29119","Demonio de Tazmania icon",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasCinco.add(
            PartidaPedido(3250,1234,"B29200","Garrafon de Agua",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasCinco.add(
            PartidaPedido(3250,1234,"B29300","Papas Sabrita",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasCinco.add(
            PartidaPedido(3250,1234,"B29400","Chocorroles",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))
        listaPartidasCinco.add(
            PartidaPedido(3250,1234,"B29500","Galletas MArias",12.0,123.00,123.00 * 0.16,12.0 * 123.00,123.0 * 0.16 * 12))

        return listaPartidasCinco                           }



    fun fillListaPartidasPedido(): ArrayList<PartidaPedido> {

        listaPartidas = ArrayList<PartidaPedido>()

        listaPartidas.add(
            PartidaPedido
                (
                3250,
                1234,
                "B29119",
                "NombreArticulo",
                12.0,
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3250,
                1235,
                "B29118",
                "NombreArticulo",
                12.0,
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3250,
                1236,
                "B30500",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3251,
                1237,
                "B30510",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3251,
                1238,
                "B30520",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3251,
                1239,
                "B30521",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3251,
                1240,
                "B30522",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3251,
                1241,
                "B35222",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3252,
                1242,
                "B35223",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3252,
                1243,
                "B35224",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3252,
                1244,
                "B35225",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3252,
                1245,
                "B40501",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3253,
                1246,
                "B40502",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3253,
                1247,
                "B40503",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3253,
                1248,
                "B52600",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3253,
                1249,
                "B52601",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )
        listaPartidas.add(
            PartidaPedido
                (
                3253,
                1250,
                "B52601",
                "NombreArticulo",
                123.00,
                123.00 * 0.16,
                12.0 * 123.00,
                12.0 * 123.00,
                123.0 * 0.16 * 12
            )
        )

   return  listaPartidas
    }
}