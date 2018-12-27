<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

	<title>ChooseIT - Login</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<!-- Basic Styles -->
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/font-awesome.min.css">

	<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/smartadmin-production-plugins.min.css">
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/smartadmin-production.min.css">
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/smartadmin-skins.min.css">

	<!-- SmartAdmin RTL Support  -->
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/smartadmin-rtl.min.css">

	<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

	<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
	<link rel="stylesheet" type="text/css" media="screen"
		href="css/demo.min.css">

	<!-- FAVICONS -->
	<link rel="shortcut icon" href="img/favicon/favicon.ico"
		type="image/x-icon">
	<link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon">

	<!-- GOOGLE FONT -->
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

	<!-- Specifying a Webpage Icon for Web Clip 
			 Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
	<link rel="apple-touch-icon" href="img/splash/sptouch-icon-iphone.png">
	<link rel="apple-touch-icon" sizes="76x76"
		href="img/splash/touch-icon-ipad.png">
	<link rel="apple-touch-icon" sizes="120x120"
		href="img/splash/touch-icon-iphone-retina.png">
	<link rel="apple-touch-icon" sizes="152x152"
		href="img/splash/touch-icon-ipad-retina.png">

</head>

<body>

	<%
		//Recupero del ruolo: se non esiste, ruolo è "guest"
		String ruolo = (String) request.getSession().getAttribute("ruolo");
		if (ruolo == null) {
			ruolo = "guest";
			request.getSession().setAttribute("ruolo", ruolo);
		}
	%>

	<!-- HEADER -->
	<header id="header"> </header>
	<!-- END HEADER -->

	<!-- Left panel : Navigation area -->
	<!-- Note: This width of the aside area can be adjusted through LESS variables -->
	<aside id="left-panel">

		<!-- User info -->
		<div class="login-info"></div>
		<!-- end user info -->

		<!-- NAVIGATION : This navigation is also responsive-->
		<nav>
			<!-- 
				NOTE: Notice the gaps after each icon usage <i></i>..
				Please note that these links work a bit different than
				traditional href="" links. See documentation for details.
				-->

			<ul>
				<li class="active open">
					<a href="index.jsp" title="Login">
						<span class="menu-item-parent">Login</span>
					</a>
				</li>
				<li>
					<a href="Registrazione.jsp">
						<span class="menu-item-parent">Registrazione</span>
					</a>
				</li>
			</ul>
		</nav>

	</aside>
	<!-- END NAVIGATION -->

	<!-- MAIN PANEL -->
	<div id="main" role="main">

		<!-- RIBBON -->
		<div id="ribbon">

			<!-- breadcrumb -->
			<ol class="breadcrumb">
				<li>Home</li>
				<li>Login</li>
			</ol>
			<!-- end breadcrumb -->

			<!-- You can also add more buttons to the
				ribbon for further usability

				Example below:

				<span class="ribbon-button-alignment pull-right">
				<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
				<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
				<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span> -->

		</div>
		<!-- END RIBBON -->

		<!-- MAIN CONTENT -->
		<div id="content">	
			<!-- widget grid -->
				<section id="widget-grid" class="">
				
					<!-- row -->
					<div class="row">
				
						<!-- NEW WIDGET START -->
						<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				
							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget jarviswidget-color-darken" id="wid-id-0" data-widget-editbutton="false">
								<!-- widget options:
								usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">
				
								data-widget-colorbutton="false"
								data-widget-editbutton="false"
								data-widget-togglebutton="false"
								data-widget-deletebutton="false"
								data-widget-fullscreenbutton="false"
								data-widget-custombutton="false"
								data-widget-collapsed="true"
								data-widget-sortable="false"
				
								-->
								<header>
									<span class="widget-icon"> <i class="fa fa-table"></i> </span>
									<h2>Standard Data Tables </h2>
				
								</header>
				
								<!-- widget div-->
								<div>
				
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->
				
									</div>
									<!-- end widget edit box -->
				
									<!-- widget content -->
									<div class="widget-body no-padding">
				
										<table id="dt_basic" class="table table-striped table-bordered table-hover" width="100%">
											<thead>			                
												<tr>
													<th data-hide="phone">ID</th>
													<th data-class="expand"><i class="fa fa-fw fa-user text-muted hidden-md hidden-sm hidden-xs"></i> Name</th>
													<th data-hide="phone"><i class="fa fa-fw fa-phone text-muted hidden-md hidden-sm hidden-xs"></i> Phone</th>
													<th>Company</th>
													<th data-hide="phone,tablet"><i class="fa fa-fw fa-map-marker txt-color-blue hidden-md hidden-sm hidden-xs"></i> Zip</th>
													<th data-hide="phone,tablet">City</th>
													<th data-hide="phone,tablet"><i class="fa fa-fw fa-calendar txt-color-blue hidden-md hidden-sm hidden-xs"></i> Date</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>1</td>
													<td>Jennifer</td>
													<td>1-342-463-8341</td>
													<td>Et Rutrum Non Associates</td>
													<td>35728</td>
													<td>Fogo</td>
													<td>03/04/14</td>
												</tr>
												<tr>
													<td>2</td>
													<td>Clark</td>
													<td>1-516-859-1120</td>
													<td>Nam Ac Inc.</td>
													<td>7162</td>
													<td>Machelen</td>
													<td>03/23/13</td>
												</tr>
												<tr>
													<td>3</td>
													<td>Brendan</td>
													<td>1-724-406-2487</td>
													<td>Enim Commodo Limited</td>
													<td>98611</td>
													<td>Norman</td>
													<td>02/13/14</td>
												</tr>
												<tr>
													<td>4</td>
													<td>Warren</td>
													<td>1-412-485-9725</td>
													<td>Odio Etiam Institute</td>
													<td>10312</td>
													<td>Sautin</td>
													<td>01/01/13</td>
												</tr>
												<tr>
													<td>5</td>
													<td>Rajah</td>
													<td>1-849-642-8777</td>
													<td>Neque Ltd</td>
													<td>29131</td>
													<td>Glovertown</td>
													<td>02/16/13</td>
												</tr>
												<tr>
													<td>6</td>
													<td>Demetrius</td>
													<td>1-470-329-9627</td>
													<td>Euismod In Ltd</td>
													<td>1883</td>
													<td>Kapolei</td>
													<td>03/15/13</td>
												</tr>
												<tr>
													<td>7</td>
													<td>Keefe</td>
													<td>1-188-191-2346</td>
													<td>Molestie Industries</td>
													<td>2211BM</td>
													<td>Modena</td>
													<td>07/08/13</td>
												</tr>
												<tr>
													<td>8</td>
													<td>Leila</td>
													<td>1-663-655-8904</td>
													<td>Est LLC</td>
													<td>75286</td>
													<td>Hondelange</td>
													<td>12/09/12</td>
												</tr>
												<tr>
													<td>9</td>
													<td>Fritz</td>
													<td>1-598-234-7837</td>
													<td>Et Ultrices Posuere Institute</td>
													<td>2324</td>
													<td>Monte San Pietrangeli</td>
													<td>12/29/12</td>
												</tr>
												<tr>
													<td>10</td>
													<td>Cassady</td>
													<td>1-212-965-8381</td>
													<td>Vitae Erat Vel Company</td>
													<td>5898</td>
													<td>Huntly</td>
													<td>10/07/13</td>
												</tr>
												<tr>
													<td>11</td>
													<td>Rogan</td>
													<td>1-541-654-9030</td>
													<td>Iaculis Incorporated</td>
													<td>6464JN</td>
													<td>Carson City</td>
													<td>05/30/13</td>
												</tr>
												<tr>
													<td>12</td>
													<td>Candice</td>
													<td>1-153-708-6027</td>
													<td>Pellentesque Company</td>
													<td>8565</td>
													<td>Redruth</td>
													<td>02/25/14</td>
												</tr>
												<tr>
													<td>13</td>
													<td>Brittany</td>
													<td>1-987-452-6038</td>
													<td>Suspendisse Inc.</td>
													<td>4031</td>
													<td>Carapicuíba</td>
													<td>10/13/13</td>
												</tr>
												<tr>
													<td>14</td>
													<td>Baxter</td>
													<td>1-281-147-5085</td>
													<td>Nulla Donec Non Associates</td>
													<td>53067</td>
													<td>Yellowknife</td>
													<td>08/14/14</td>
												</tr>
												<tr>
													<td>15</td>
													<td>Vaughan</td>
													<td>1-940-231-1787</td>
													<td>Metus Facilisis Lorem Incorporated</td>
													<td>26530-046</td>
													<td>Guarapuava</td>
													<td>11/17/12</td>
												</tr>
												<tr>
													<td>16</td>
													<td>Ivan</td>
													<td>1-314-209-1223</td>
													<td>Posuere Vulputate Inc.</td>
													<td>KX3W 1OI</td>
													<td>Bienne-lez-Happart</td>
													<td>03/04/14</td>
												</tr>
												<tr>
													<td>17</td>
													<td>Marah</td>
													<td>1-348-582-4041</td>
													<td>Feugiat Ltd</td>
													<td>2128</td>
													<td>Nîmes</td>
													<td>11/29/12</td>
												</tr>
												<tr>
													<td>18</td>
													<td>Kiara</td>
													<td>1-570-428-6681</td>
													<td>Et Euismod Et Corp.</td>
													<td>70483</td>
													<td>Meeuwen</td>
													<td>03/28/13</td>
												</tr>
												<tr>
													<td>19</td>
													<td>Brielle</td>
													<td>1-216-787-0056</td>
													<td>Quis Massa Mauris Institute</td>
													<td>19913</td>
													<td>Mombaruzzo</td>
													<td>12/17/12</td>
												</tr>
												<tr>
													<td>20</td>
													<td>Kennedy</td>
													<td>1-997-154-9340</td>
													<td>Quis Diam Pellentesque Institute</td>
													<td>3092FI</td>
													<td>Edmundston</td>
													<td>02/26/13</td>
												</tr>
												<tr>
													<td>21</td>
													<td>Peter</td>
													<td>1-394-459-3833</td>
													<td>Mauris Eu Turpis Corporation</td>
													<td>27337</td>
													<td>Ravenstein</td>
													<td>06/05/14</td>
												</tr>
												<tr>
													<td>22</td>
													<td>Kibo</td>
													<td>1-162-467-7160</td>
													<td>Massa LLP</td>
													<td>30305</td>
													<td>Witney</td>
													<td>08/20/14</td>
												</tr>
												<tr>
													<td>23</td>
													<td>Tanek</td>
													<td>1-806-556-1897</td>
													<td>Pharetra Nam Industries</td>
													<td>84972</td>
													<td>Abbotsford</td>
													<td>05/03/14</td>
												</tr>
												<tr>
													<td>24</td>
													<td>Guinevere</td>
													<td>1-850-940-6176</td>
													<td>Montes Nascetur Limited</td>
													<td>54983</td>
													<td>Rio Grande</td>
													<td>02/24/14</td>
												</tr>
												<tr>
													<td>25</td>
													<td>Ronan</td>
													<td>1-168-544-4394</td>
													<td>Nunc Inc.</td>
													<td>12167</td>
													<td>Pinkafeld</td>
													<td>01/02/13</td>
												</tr>
												<tr>
													<td>26</td>
													<td>Kasper</td>
													<td>1-153-221-5650</td>
													<td>Rutrum Limited</td>
													<td>M9N 0N6</td>
													<td>Saint-G?ry</td>
													<td>04/03/14</td>
												</tr>
												<tr>
													<td>27</td>
													<td>Otto</td>
													<td>1-894-944-5767</td>
													<td>Purus Maecenas Libero LLC</td>
													<td>74552-602</td>
													<td>Jauche</td>
													<td>11/17/13</td>
												</tr>
												<tr>
													<td>28</td>
													<td>Brenda</td>
													<td>1-783-562-8563</td>
													<td>Sit Consulting</td>
													<td>15632</td>
													<td>Llandrindod Wells</td>
													<td>08/13/14</td>
												</tr>
												<tr>
													<td>29</td>
													<td>Laith</td>
													<td>1-482-317-8464</td>
													<td>Tellus Limited</td>
													<td>P8L 2V5</td>
													<td>Codó</td>
													<td>11/02/13</td>
												</tr>
												<tr>
													<td>30</td>
													<td>Ella</td>
													<td>1-275-839-6518</td>
													<td>Tincidunt Inc.</td>
													<td>V8L 7Y0</td>
													<td>Lummen</td>
													<td>09/29/13</td>
												</tr>
												<tr>
													<td>31</td>
													<td>Hanae</td>
													<td>1-339-661-4197</td>
													<td>Nunc Incorporated</td>
													<td>47931</td>
													<td>South Burlington</td>
													<td>05/19/14</td>
												</tr>
												<tr>
													<td>32</td>
													<td>Donna</td>
													<td>1-236-575-1365</td>
													<td>Ultricies Sem Incorporated</td>
													<td>78685</td>
													<td>Baranello</td>
													<td>02/19/13</td>
												</tr>
												<tr>
													<td>33</td>
													<td>Bevis</td>
													<td>1-955-717-0835</td>
													<td>Est Ac Inc.</td>
													<td>7424</td>
													<td>Ichtegem</td>
													<td>08/15/13</td>
												</tr>
												<tr>
													<td>34</td>
													<td>Celeste</td>
													<td>1-368-137-6285</td>
													<td>Tortor Nibh Sit Inc.</td>
													<td>01318</td>
													<td>Portobuffolè</td>
													<td>05/28/14</td>
												</tr>
												<tr>
													<td>35</td>
													<td>Ila</td>
													<td>1-315-684-6122</td>
													<td>Gravida Sagittis Associates</td>
													<td>4438PF</td>
													<td>Keswick</td>
													<td>11/22/13</td>
												</tr>
												<tr>
													<td>36</td>
													<td>Alana</td>
													<td>1-586-261-7830</td>
													<td>Nullam Industries</td>
													<td>6044</td>
													<td>Bacabal</td>
													<td>03/04/13</td>
												</tr>
												<tr>
													<td>37</td>
													<td>Rowan</td>
													<td>1-782-168-2387</td>
													<td>Aliquet Consulting</td>
													<td>33000</td>
													<td>Papasidero</td>
													<td>02/06/14</td>
												</tr>
												<tr>
													<td>38</td>
													<td>Eric</td>
													<td>1-161-390-1140</td>
													<td>Odio Institute</td>
													<td>5652</td>
													<td>Moliterno</td>
													<td>03/14/13</td>
												</tr>
												<tr>
													<td>39</td>
													<td>Dana</td>
													<td>1-989-320-2205</td>
													<td>Bibendum Fermentum Institute</td>
													<td>X31 1HZ</td>
													<td>Saint-Pierre</td>
													<td>02/25/13</td>
												</tr>
												<tr>
													<td>40</td>
													<td>Karleigh</td>
													<td>1-218-513-8714</td>
													<td>Duis Volutpat Inc.</td>
													<td>1356</td>
													<td>Fresno</td>
													<td>06/09/14</td>
												</tr>
												<tr>
													<td>41</td>
													<td>Malik</td>
													<td>1-869-972-9871</td>
													<td>Praesent Luctus Curabitur Limited</td>
													<td>V3Y 0P0</td>
													<td>Roxboro</td>
													<td>05/09/14</td>
												</tr>
												<tr>
													<td>42</td>
													<td>May</td>
													<td>1-462-220-8205</td>
													<td>Suspendisse Dui LLP</td>
													<td>4765</td>
													<td>Mold</td>
													<td>06/15/13</td>
												</tr>
												<tr>
													<td>43</td>
													<td>Alan</td>
													<td>1-478-769-3709</td>
													<td>Suspendisse Inc.</td>
													<td>7354AC</td>
													<td>Norfolk</td>
													<td>03/09/14</td>
												</tr>
												<tr>
													<td>44</td>
													<td>Anastasia</td>
													<td>1-589-358-5285</td>
													<td>Mus Proin Institute</td>
													<td>33244</td>
													<td>Montbliart</td>
													<td>06/18/14</td>
												</tr>
												<tr>
													<td>45</td>
													<td>Yardley</td>
													<td>1-422-907-2926</td>
													<td>Urna Et LLP</td>
													<td>88531</td>
													<td>Évreux</td>
													<td>05/23/14</td>
												</tr>
												<tr>
													<td>46</td>
													<td>Oscar</td>
													<td>1-476-548-4758</td>
													<td>Nunc Id Enim Institute</td>
													<td>T5Z 4YS</td>
													<td>Burlington</td>
													<td>08/26/14</td>
												</tr>
												<tr>
													<td>47</td>
													<td>Hasad</td>
													<td>1-397-946-7346</td>
													<td>Auctor Nunc Corp.</td>
													<td>2307HU</td>
													<td>Savona</td>
													<td>10/29/13</td>
												</tr>
												<tr>
													<td>48</td>
													<td>Mohammad</td>
													<td>1-984-931-7753</td>
													<td>Ultricies Dignissim LLP</td>
													<td>4718</td>
													<td>Nadrin</td>
													<td>12/08/13</td>
												</tr>
												<tr>
													<td>49</td>
													<td>Nissim</td>
													<td>1-739-146-3150</td>
													<td>Lacus Ltd</td>
													<td>UX95 5JM</td>
													<td>Veere</td>
													<td>08/19/14</td>
												</tr>
												<tr>
													<td>50</td>
													<td>Porter</td>
													<td>1-299-790-1428</td>
													<td>Aliquam LLC</td>
													<td>41708</td>
													<td>Montaldo Bormida</td>
													<td>11/02/12</td>
												</tr>
												<tr>
													<td>51</td>
													<td>Sophia</td>
													<td>1-413-195-0820</td>
													<td>Viverra Maecenas Iaculis Ltd</td>
													<td>83468</td>
													<td>Doetinchem</td>
													<td>09/28/13</td>
												</tr>
												<tr>
													<td>52</td>
													<td>Acton</td>
													<td>1-855-937-9214</td>
													<td>Vitae Sodales Company</td>
													<td>1757</td>
													<td>Bad Oldesloe</td>
													<td>04/13/13</td>
												</tr>
												<tr>
													<td>53</td>
													<td>Briar</td>
													<td>1-846-339-0222</td>
													<td>Congue Turpis In Limited</td>
													<td>51510</td>
													<td>Caerphilly</td>
													<td>02/06/13</td>
												</tr>
												<tr>
													<td>54</td>
													<td>Benjamin</td>
													<td>1-828-436-8902</td>
													<td>Aliquam Nec Enim Ltd</td>
													<td>4289GW</td>
													<td>Holyhead</td>
													<td>12/17/13</td>
												</tr>
												<tr>
													<td>55</td>
													<td>Gregory</td>
													<td>1-782-119-9191</td>
													<td>A PC</td>
													<td>14531</td>
													<td>Águas Lindas de Goiás</td>
													<td>04/11/14</td>
												</tr>
												<tr>
													<td>56</td>
													<td>Marny</td>
													<td>1-255-275-2769</td>
													<td>Malesuada Institute</td>
													<td>41706</td>
													<td>Montaldo Bormida</td>
													<td>12/19/13</td>
												</tr>
												<tr>
													<td>57</td>
													<td>Indira</td>
													<td>1-215-687-1488</td>
													<td>Augue Id Ante PC</td>
													<td>42010</td>
													<td>Lorient</td>
													<td>09/02/13</td>
												</tr>
												<tr>
													<td>58</td>
													<td>Fleur</td>
													<td>1-309-181-4794</td>
													<td>Libero Donec Consectetuer Corp.</td>
													<td>ZD4H 3NF</td>
													<td>Valleyview</td>
													<td>01/13/14</td>
												</tr>
												<tr>
													<td>59</td>
													<td>Fulton</td>
													<td>1-380-339-9492</td>
													<td>Vulputate LLP</td>
													<td>01154</td>
													<td>Blois</td>
													<td>04/16/13</td>
												</tr>
												<tr>
													<td>60</td>
													<td>Arsenio</td>
													<td>1-794-184-3132</td>
													<td>Nec Diam Duis Ltd</td>
													<td>91908</td>
													<td>Foligno</td>
													<td>05/24/13</td>
												</tr>
												<tr>
													<td>61</td>
													<td>Jaden</td>
													<td>1-979-292-4559</td>
													<td>Vestibulum Ante Industries</td>
													<td>2724</td>
													<td>Bertogne</td>
													<td>06/16/14</td>
												</tr>
												<tr>
													<td>62</td>
													<td>Kylie</td>
													<td>1-900-819-9083</td>
													<td>Arcu Vestibulum Ut Incorporated</td>
													<td>E6R 8N1</td>
													<td>Scandriglia</td>
													<td>03/19/14</td>
												</tr>
												<tr>
													<td>63</td>
													<td>Melyssa</td>
													<td>1-911-370-2794</td>
													<td>Pede Sagittis Augue Ltd</td>
													<td>37293</td>
													<td>Frauenkirchen</td>
													<td>08/31/13</td>
												</tr>
												<tr>
													<td>64</td>
													<td>Jerry</td>
													<td>1-501-422-6929</td>
													<td>Nonummy Ut Molestie LLP</td>
													<td>9024</td>
													<td>Nossegem</td>
													<td>07/22/13</td>
												</tr>
												<tr>
													<td>65</td>
													<td>Rhiannon</td>
													<td>1-188-451-3938</td>
													<td>Elit Pellentesque Consulting</td>
													<td>12283</td>
													<td>College</td>
													<td>08/16/14</td>
												</tr>
												<tr>
													<td>66</td>
													<td>Price</td>
													<td>1-769-162-9068</td>
													<td>Vitae Erat Vivamus Corp.</td>
													<td>6843</td>
													<td>Villata</td>
													<td>08/18/14</td>
												</tr>
												<tr>
													<td>67</td>
													<td>Ginger</td>
													<td>1-263-395-0268</td>
													<td>Ligula Institute</td>
													<td>1979</td>
													<td>Rodengo/Rodeneck</td>
													<td>06/14/13</td>
												</tr>
												<tr>
													<td>68</td>
													<td>Britanney</td>
													<td>1-121-616-0992</td>
													<td>Nec Diam LLP</td>
													<td>07095</td>
													<td>Queanbeyan</td>
													<td>09/01/13</td>
												</tr>
												<tr>
													<td>69</td>
													<td>Wylie</td>
													<td>1-736-996-8984</td>
													<td>Arcu Industries</td>
													<td>7587LK</td>
													<td>Fauglia</td>
													<td>01/24/13</td>
												</tr>
												<tr>
													<td>70</td>
													<td>Holly</td>
													<td>1-210-117-9053</td>
													<td>Adipiscing Incorporated</td>
													<td>9053</td>
													<td>Dortmund</td>
													<td>04/21/13</td>
												</tr>
												<tr>
													<td>71</td>
													<td>Althea</td>
													<td>1-525-409-7849</td>
													<td>Vel Company</td>
													<td>20125</td>
													<td>Qualicum Beach</td>
													<td>09/27/13</td>
												</tr>
												<tr>
													<td>72</td>
													<td>Quintessa</td>
													<td>1-947-731-6466</td>
													<td>Nunc Interdum Foundation</td>
													<td>3260</td>
													<td>Llandrindod Wells</td>
													<td>04/06/13</td>
												</tr>
												<tr>
													<td>73</td>
													<td>Fitzgerald</td>
													<td>1-725-747-2841</td>
													<td>Torquent Associates</td>
													<td>01688-439</td>
													<td>Manchester</td>
													<td>02/06/14</td>
												</tr>
												<tr>
													<td>74</td>
													<td>Keefe</td>
													<td>1-672-945-4291</td>
													<td>Mollis Dui PC</td>
													<td>73231</td>
													<td>Hillsboro</td>
													<td>06/24/13</td>
												</tr>
												<tr>
													<td>75</td>
													<td>Rudyard</td>
													<td>1-504-162-2567</td>
													<td>Ipsum Curabitur Consequat Foundation</td>
													<td>Xxxx</td>
													<td>Kimberly</td>
													<td>12/12/13</td>
												</tr>
												<tr>
													<td>76</td>
													<td>Kareem</td>
													<td>1-716-663-9703</td>
													<td>In Ltd</td>
													<td>2707</td>
													<td>Legal</td>
													<td>01/29/14</td>
												</tr>
												<tr>
													<td>77</td>
													<td>Genevieve</td>
													<td>1-361-358-3030</td>
													<td>Mi PC</td>
													<td>4995</td>
													<td>Crieff</td>
													<td>04/25/13</td>
												</tr>
												<tr>
													<td>78</td>
													<td>Wang</td>
													<td>1-806-922-8622</td>
													<td>Lacinia Vitae Corporation</td>
													<td>1850UC</td>
													<td>Rudiano</td>
													<td>04/05/14</td>
												</tr>
												<tr>
													<td>79</td>
													<td>Odessa</td>
													<td>1-983-915-7779</td>
													<td>Dolor Donec Corporation</td>
													<td>L2M 1L6</td>
													<td>Siddi</td>
													<td>01/05/13</td>
												</tr>
												<tr>
													<td>80</td>
													<td>Adrienne</td>
													<td>1-771-540-3805</td>
													<td>Eu Lacus Incorporated</td>
													<td>2116</td>
													<td>Lincoln</td>
													<td>09/13/14</td>
												</tr>
												<tr>
													<td>81</td>
													<td>Charity</td>
													<td>1-749-804-8328</td>
													<td>Aenean Sed Pede Foundation</td>
													<td>14470-440</td>
													<td>Haverfordwest</td>
													<td>08/01/13</td>
												</tr>
												<tr>
													<td>82</td>
													<td>Kieran</td>
													<td>1-333-507-3878</td>
													<td>Malesuada Ut Sem Corp.</td>
													<td>W3C 3PM</td>
													<td>Croydon</td>
													<td>10/30/13</td>
												</tr>
												<tr>
													<td>83</td>
													<td>Alika</td>
													<td>1-544-422-1437</td>
													<td>Integer Tincidunt Company</td>
													<td>Xxxx</td>
													<td>Plymouth</td>
													<td>12/26/12</td>
												</tr>
												<tr>
													<td>84</td>
													<td>Shay</td>
													<td>1-530-583-8669</td>
													<td>Diam LLP</td>
													<td>63260</td>
													<td>College</td>
													<td>08/20/14</td>
												</tr>
												<tr>
													<td>85</td>
													<td>Cailin</td>
													<td>1-415-254-8139</td>
													<td>Placerat Eget Foundation</td>
													<td>L3M 4R6</td>
													<td>Jonqui?re</td>
													<td>09/12/14</td>
												</tr>
												<tr>
													<td>86</td>
													<td>Xena</td>
													<td>1-979-983-1456</td>
													<td>Tellus Eu Augue Associates</td>
													<td>09703-746</td>
													<td>Angleur</td>
													<td>05/21/13</td>
												</tr>
												<tr>
													<td>87</td>
													<td>Walker</td>
													<td>1-380-277-2755</td>
													<td>Sollicitudin A Malesuada Corporation</td>
													<td>60019</td>
													<td>Toronto</td>
													<td>06/11/14</td>
												</tr>
												<tr>
													<td>88</td>
													<td>Adena</td>
													<td>1-756-948-8416</td>
													<td>Diam Ltd</td>
													<td>B7T 5X7</td>
													<td>Stene</td>
													<td>05/30/14</td>
												</tr>
												<tr>
													<td>89</td>
													<td>Bradley</td>
													<td>1-800-808-3688</td>
													<td>Nunc Quis LLC</td>
													<td>83932-949</td>
													<td>Uppingham. Cottesmore</td>
													<td>11/05/13</td>
												</tr>
												<tr>
													<td>90</td>
													<td>Yvette</td>
													<td>1-843-923-0038</td>
													<td>Eget Metus PC</td>
													<td>47936</td>
													<td>Feira de Santana</td>
													<td>06/27/14</td>
												</tr>
												<tr>
													<td>91</td>
													<td>Neil</td>
													<td>1-550-664-4050</td>
													<td>Aenean Euismod LLP</td>
													<td>28842</td>
													<td>Corby</td>
													<td>07/27/14</td>
												</tr>
												<tr>
													<td>92</td>
													<td>Hunter</td>
													<td>1-637-483-4408</td>
													<td>In Nec Orci LLC</td>
													<td>49338</td>
													<td>Cleveland</td>
													<td>01/15/13</td>
												</tr>
												<tr>
													<td>93</td>
													<td>Marcia</td>
													<td>1-512-896-6301</td>
													<td>Et Risus Industries</td>
													<td>74123</td>
													<td>Quinte West</td>
													<td>09/30/13</td>
												</tr>
												<tr>
													<td>94</td>
													<td>Lavinia</td>
													<td>1-222-745-5312</td>
													<td>Nulla Interdum Curabitur LLC</td>
													<td>3531</td>
													<td>Assiniboia</td>
													<td>01/12/13</td>
												</tr>
												<tr>
													<td>95</td>
													<td>Cynthia</td>
													<td>1-392-134-2788</td>
													<td>Nunc Ut Erat Company</td>
													<td>I27 5OS</td>
													<td>Pagazzano</td>
													<td>05/20/13</td>
												</tr>
												<tr>
													<td>96</td>
													<td>Lee</td>
													<td>1-128-816-7274</td>
													<td>Litora Torquent Per PC</td>
													<td>11386</td>
													<td>Mazzano Romano</td>
													<td>04/18/14</td>
												</tr>
												<tr>
													<td>97</td>
													<td>Linda</td>
													<td>1-546-735-8920</td>
													<td>Dis Parturient Montes Associates</td>
													<td>64629</td>
													<td>Ferlach</td>
													<td>03/29/14</td>
												</tr>
												<tr>
													<td>98</td>
													<td>Wayne</td>
													<td>1-744-647-6144</td>
													<td>In Industries</td>
													<td>Xxxx</td>
													<td>Memphis</td>
													<td>06/11/14</td>
												</tr>
												<tr>
													<td>99</td>
													<td>Liberty</td>
													<td>1-841-489-1665</td>
													<td>Sed Sem Limited</td>
													<td>27504-649</td>
													<td>Olivola</td>
													<td>05/24/14</td>
												</tr>
												<tr>
													<td>100</td>
													<td>Cathleen</td>
													<td>1-883-567-6065</td>
													<td>Eu Corporation</td>
													<td>4286</td>
													<td>Rotheux-Rimi?re</td>
													<td>07/16/13</td>
												</tr>
											</tbody>
										</table>

									</div>
									<!-- end widget content -->
				
								</div>
								<!-- end widget div -->
				
							</div>
							<!-- end widget -->
							
					</article>
						<!-- WIDGET END -->
				
					</div>
				
					<!-- end row -->
				
					<!-- end row -->
				
				</section>
				<!-- end widget grid -->
				</div>
		<!-- END MAIN CONTENT -->
	</div>
	<!-- END MAIN PANEL -->
	
	<!-- PAGE FOOTER -->
	<div class="page-footer">
		<div class="row">
			<div class="col-xs-12 col-sm-6">
				<span class="txt-color-white">ChooseIT <span
					class="hidden-xs"></span> © 2018-2019
				</span>
			</div>
		</div>
	</div>
	<!-- END PAGE FOOTER -->

</body>
</html>