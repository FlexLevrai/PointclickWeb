-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 08 avr. 2022 à 16:23
-- Version du serveur : 10.4.21-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `point_click_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `annee`
--

CREATE TABLE `annee` (
  `id` bigint(20) NOT NULL,
  `etat` bit(1) NOT NULL,
  `libelle` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `annee`
--

INSERT INTO `annee` (`id`, `etat`, `libelle`) VALUES
(1, b'0', '2020'),
(3, b'0', '2021'),
(4, b'1', '2022');

-- --------------------------------------------------------

--
-- Structure de la table `detail_journee`
--

CREATE TABLE `detail_journee` (
  `id` bigint(20) NOT NULL,
  `heure_arrive` varchar(255) NOT NULL,
  `heure_debut_pause` varchar(255) NOT NULL,
  `heure_depart` varchar(255) NOT NULL,
  `heure_fin_pause` varchar(255) NOT NULL,
  `id_journee` bigint(20) NOT NULL,
  `id_personnel` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `detail_journee`
--

INSERT INTO `detail_journee` (`id`, `heure_arrive`, `heure_debut_pause`, `heure_depart`, `heure_fin_pause`, `id_journee`, `id_personnel`) VALUES
(1, '7h00', '12h00', '17h00', '14h30', 1, 2),
(2, '7h00', '12h00', '17h00', '14h30', 2, 2),
(3, '7h00', '12h00', '17h00', '14h30', 3, 2),
(4, '7h00', '12h00', '17h00', '14h30', 4, 2),
(6, '7h00', '12h00', '17h00', '14h00', 5, 2);

-- --------------------------------------------------------

--
-- Structure de la table `exercice_journee`
--

CREATE TABLE `exercice_journee` (
  `id` bigint(20) NOT NULL,
  `date_jour` date DEFAULT NULL,
  `fin_heure_sortie_speciale` time DEFAULT NULL,
  `heure_arrive` time DEFAULT NULL,
  `heure_debut_pause` time DEFAULT NULL,
  `heure_depart` time DEFAULT NULL,
  `heure_fin_pause` time DEFAULT NULL,
  `heure_sortie_speciale` time DEFAULT NULL,
  `motif` varchar(255) DEFAULT NULL,
  `id_personnel` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `exercice_journee`
--

INSERT INTO `exercice_journee` (`id`, `date_jour`, `fin_heure_sortie_speciale`, `heure_arrive`, `heure_debut_pause`, `heure_depart`, `heure_fin_pause`, `heure_sortie_speciale`, `motif`, `id_personnel`) VALUES
(1, '2022-03-27', NULL, '22:00:46', NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `journee`
--

CREATE TABLE `journee` (
  `id` bigint(20) NOT NULL,
  `etat` bit(1) NOT NULL,
  `libelle` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `journee`
--

INSERT INTO `journee` (`id`, `etat`, `libelle`) VALUES
(1, b'1', 'Lundi'),
(2, b'0', 'Mardi'),
(3, b'0', 'Mercredi'),
(4, b'0', 'Jeudi'),
(5, b'0', 'Vendredi'),
(6, b'0', 'Samedi');

-- --------------------------------------------------------

--
-- Structure de la table `mois`
--

CREATE TABLE `mois` (
  `id` bigint(20) NOT NULL,
  `etat` bit(1) NOT NULL,
  `libelle` varchar(30) NOT NULL,
  `id_annee` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `mois`
--

INSERT INTO `mois` (`id`, `etat`, `libelle`, `id_annee`) VALUES
(1, b'0', 'Janvier', 3),
(3, b'0', 'Fevrier', 3),
(4, b'1', 'Mars', 3),
(5, b'0', 'Mais', 3),
(6, b'0', 'Avril', 3),
(7, b'0', 'Juin', 3),
(8, b'0', 'Juillet', 3),
(9, b'0', 'Août', 3),
(10, b'0', 'Septembre', 3),
(11, b'0', 'Octobre', 3),
(12, b'0', 'Novembre', 3),
(13, b'0', 'Décembre', 3);

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `id` bigint(20) NOT NULL,
  `adresse` varchar(101) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `date_naissance` date NOT NULL,
  `lieu_naissance` varchar(101) NOT NULL,
  `nom` varchar(101) NOT NULL,
  `prenom` varchar(101) NOT NULL,
  `sexe` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`id`, `adresse`, `contact`, `date_naissance`, `lieu_naissance`, `nom`, `prenom`, `sexe`) VALUES
(2, 'Lome', '92026860', '2022-03-18', 'Lome', 'MIEGOU', 'Roger', 'M'),
(3, 'Legbassito', '90755', '2022-03-25', 'Lomé', 'KONDI', 'Emmanuel', 'M'),
(4, 'Lomé', '9077658', '1999-07-25', 'Lomé', 'BEDEMA', 'Marcel', 'M');

-- --------------------------------------------------------

--
-- Structure de la table `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(101) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'Administrateur'),
(2, 'Utilisateur');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `id` bigint(20) NOT NULL,
  `date_save` date NOT NULL,
  `name` varchar(101) NOT NULL,
  `password` varchar(101) NOT NULL,
  `username` varchar(101) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `date_save`, `name`, `password`, `username`) VALUES
(1, '2021-11-08', 'Mairie', '$2a$10$zYeHlO/F3flbfFSlj.rcbuLv99Uk/oHCUanbj7CkYG4dwH04kHTs6', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs_roles`
--

CREATE TABLE `utilisateurs_roles` (
  `utilisateur_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateurs_roles`
--

INSERT INTO `utilisateurs_roles` (`utilisateur_id`, `roles_id`) VALUES
(1, 1),
(1, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annee`
--
ALTER TABLE `annee`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `detail_journee`
--
ALTER TABLE `detail_journee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKighxqlrwixv2cljpsjjv2ij5g` (`id_journee`),
  ADD KEY `FKtro6v1wj5kiw7rkba0mq3ag84` (`id_personnel`);

--
-- Index pour la table `exercice_journee`
--
ALTER TABLE `exercice_journee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKm7mhn5juw718ajocma8ecej76` (`id_personnel`);

--
-- Index pour la table `journee`
--
ALTER TABLE `journee`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `mois`
--
ALTER TABLE `mois`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK37vojna8vc96jfhpgvhiscuhl` (`id_annee`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_l8ivthvih63lgxwa4uqwmbqj9` (`username`);

--
-- Index pour la table `utilisateurs_roles`
--
ALTER TABLE `utilisateurs_roles`
  ADD KEY `FKg0thxn6kr221ykrpy1rfocofr` (`roles_id`),
  ADD KEY `FKn6gc9xu3vj7iivdrllrkmgyej` (`utilisateur_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `annee`
--
ALTER TABLE `annee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `detail_journee`
--
ALTER TABLE `detail_journee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `exercice_journee`
--
ALTER TABLE `exercice_journee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `journee`
--
ALTER TABLE `journee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `mois`
--
ALTER TABLE `mois`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `detail_journee`
--
ALTER TABLE `detail_journee`
  ADD CONSTRAINT `FKighxqlrwixv2cljpsjjv2ij5g` FOREIGN KEY (`id_journee`) REFERENCES `journee` (`id`),
  ADD CONSTRAINT `FKtro6v1wj5kiw7rkba0mq3ag84` FOREIGN KEY (`id_personnel`) REFERENCES `personnel` (`id`);

--
-- Contraintes pour la table `exercice_journee`
--
ALTER TABLE `exercice_journee`
  ADD CONSTRAINT `FKbwuyk4vcbb4yj8opuvxrmnche` FOREIGN KEY (`id_personnel`) REFERENCES `personnel` (`id`),
  ADD CONSTRAINT `FKm7mhn5juw718ajocma8ecej76` FOREIGN KEY (`id_personnel`) REFERENCES `detail_journee` (`id`);

--
-- Contraintes pour la table `mois`
--
ALTER TABLE `mois`
  ADD CONSTRAINT `FK37vojna8vc96jfhpgvhiscuhl` FOREIGN KEY (`id_annee`) REFERENCES `annee` (`id`);

--
-- Contraintes pour la table `utilisateurs_roles`
--
ALTER TABLE `utilisateurs_roles`
  ADD CONSTRAINT `FKg0thxn6kr221ykrpy1rfocofr` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`),
  ADD CONSTRAINT `FKn6gc9xu3vj7iivdrllrkmgyej` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateurs` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
