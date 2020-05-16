package example.javatpoint.com.apppedidosmovilmicrosip.FakeDataToDB

import example.javatpoint.com.apppedidosmovilmicrosip.DataModel.Clientes

class FillTablesDataFake {

    lateinit var listaClientes:ArrayList<Clientes>

    fun fillListaClientes():ArrayList<Clientes>{

        listaClientes= ArrayList()

       listaClientes.add(Clientes(1,"Raul Ibañes",3295,1234,"2324","Prolongacion Galeana"   ,"Ixtapa",     "Cerrillo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(2,"Giovany Peralta",3295,1234,"9873", "Rioacha Salamanca"      ,"Zacango",    "Crespa", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(3,"Francisco Peña",3295,1234,"3333", "Perriferica sur vallejo","Lerma",      "Tomasquillo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(4,"MAteo Quiroz",3295,1234,"9879", "Etiopia y revolucion"   ,"Ixtaln",     "Hidalgo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(5,"Saul Ramires",3295,1234,"5465", "Genral MArtinez Pliego" ,"Tehotihuacan","Ensenada", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(6,"Leonel Mesis",3295,1234,"5454", "General Villada Lopez"  ,"San Pedro",   "Tlazcala", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(7,"Rick MOntana",3295,1234,"5456", "Herminio Gonzalez"      ,"Rio Janeiro", "Villa Flores", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(8,"Gerardo Peña",3295,1234,"5646", "Sor Juana Inez Cruz"   , "Laredo Tam",  "Geo Laredo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(9,"Leandro VAlle",3295,1234,"2324", "Prolongacion Galeana"   ,"Ixtapa",     "Cerrillo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(10,"Raul Montana",3295,1234,"7398", "Rioacha Salamanca"      ,"Zacango",    "Crespa", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(11,"Arcadio Buendia",3295,1234,"3329", "Perriferica sur vallejo","Lerma",      "Tomasquillo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(12,"Sergio Castrejon",3295,1234,"9857", "Etiopia y revolucion"   ,"Ixtaln",     "Hidalgo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(13,"MArio Peña",3295,1234,"5445", "Genral MArtinez Pliego" ,"Tehotihuacan","Ensenada", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(14,"Laura Medina",3295,1234,"9875", "General Villada Lopez"  ,"San Pedro",   "Tlazcala", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(15,"Johana Alvirde",3295,1234,"3656", "Herminio Gonzalez"      ,"Rio Janeiro", "Villa Flores", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(16,"Gerardo Rosales",3295,1234,"8751", "Sor Juana Inez Cruz"   , "Laredo Tam",  "Geo Laredo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(17,"Tiago Silva",3295,1234,"6354", "Prolongacion Galeana"   ,"Ixtapa",     "Cerrillo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(18,"Diego Cortua",3295,1234,"6546", "Rioacha Salamanca"      ,"Zacango",    "Crespa", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(19,"Franciso Lopez",3295,1234,"5465", "Perriferica sur vallejo","Lerma",      "Tomasquillo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(20,"Genaro Garcia",3295,1234,"6565", "Etiopia y revolucion"   ,"Ixtaln",     "Hidalgo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(21,"Santos Medina",3295,1234,"6555", "Genral MArtinez Pliego" ,"Tehotihuacan","Ensenada", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(22,"Luigi MArio",3295,1234,"5245", "General Villada Lopez"  ,"San Pedro",   "Tlazcala", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(23,"Ernesto Cedillo",3295,1234,"6354", "Herminio Gonzalez"      ,"Rio Janeiro", "Villa Flores", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(24,"Santos Bris",3295,1234,"3654", "Sor Juana Inez Cruz"   , "Laredo Tam",  "Geo Laredo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(25,"Adela Monrroy",3295,1234,"6365", "Prolongacion Galeana"   ,"Ixtapa",     "Cerrillo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(26,"Jose Fernandez",3295,1234,"5685", "Rioacha Salamanca"      ,"Zacango",    "Crespa", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(27,"Luis Medina",3295,1234,"3523", "Perriferica sur vallejo","Lerma",      "Tomasquillo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(28,"Felipe Salinas",3295,1234,"3659", "Etiopia y revolucion"   ,"Ixtaln",     "Hidalgo", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(29,"Roroteo Arango",3295,1234,"6564", "Genral MArtinez Pliego" ,"Tehotihuacan","Ensenada", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(30,"Shakira Madrid",3295,1234,"5664", "General Villada Lopez"  ,"San Pedro",   "Tlazcala", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(31,"Josefa Ceballos",3295,1234,"5476", "Herminio Gonzalez"      ,"Rio Janeiro", "Villa Flores", 2345.542,1234.5, 123.123,987.987))
       listaClientes.add(Clientes(32,"Lou Vega",3295,1234,"3546", "Sor Juana Inez Cruz"   , "Laredo Tam",  "Geo Laredo", 2345.542,1234.5, 123.123,987.987))

    return listaClientes

    }




}