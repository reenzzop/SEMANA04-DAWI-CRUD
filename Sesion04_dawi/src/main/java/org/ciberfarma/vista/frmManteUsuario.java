package org.ciberfarma.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ciberfarma.modelo.Usuario;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmManteUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JTextField txtClave;
	private JTextField txtFecha;
	private JTextField txtTipo;
	private JTextField txtEstado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmManteUsuario frame = new frmManteUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmManteUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mantenimiento de Usuarios");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(88, 13, 278, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(12, 80, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(12, 109, 65, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(12, 138, 65, 16);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Usuario:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(12, 167, 56, 16);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Clave:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(12, 196, 56, 16);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Fecha:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(12, 225, 56, 16);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Tipo:");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(12, 254, 56, 16);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Estado:");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_7.setBounds(12, 283, 56, 16);
		contentPane.add(lblNewLabel_1_7);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(80, 77, 83, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(80, 106, 177, 22);
		contentPane.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(80, 135, 177, 22);
		contentPane.add(txtApellido);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(80, 164, 144, 22);
		contentPane.add(txtUsuario);
		
		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(80, 193, 144, 22);
		contentPane.add(txtClave);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(80, 222, 116, 22);
		contentPane.add(txtFecha);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(80, 251, 116, 22);
		contentPane.add(txtTipo);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(80, 280, 116, 22);
		contentPane.add(txtEstado);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(337, 76, 97, 25);
		contentPane.add(btnRegistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizar();
			}
		});
		btnActualizar.setBounds(337, 105, 97, 25);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		btnEliminar.setBounds(337, 134, 97, 25);
		contentPane.add(btnEliminar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultar();
			}
		});
		btnConsultar.setBounds(337, 163, 97, 25);
		contentPane.add(btnConsultar);
	}
	void consultar(){
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();

		Usuario u = em.find(Usuario.class, Integer.parseInt(txtCodigo.getText()));

		if (u !=null) {
			txtNombre.setText(u.getNombre());		
			txtApellido.setText(u.getApellido());
			txtUsuario.setText(u.getUsuario());
			txtClave.setText(u.getClave());
			txtFecha.setText(u.getFnacim());
			txtTipo.setText(Integer.toString(u.getTipo()));
			txtEstado.setText(Integer.toString(u.getEstado()));

		} else {
			JOptionPane.showMessageDialog(this, "Usuario no existe");
			limpiar();	
		}


		em.close();
		fabrica.close();
	}
	void registrar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = new Usuario();
		u.setNombre(txtNombre.getText());
		u.setApellido(txtApellido.getText());
		u.setUsuario(txtUsuario.getText());
		u.setClave(txtClave.getText());
		u.setFnacim(txtFecha.getText());
		u.setTipo(Integer.parseInt(txtTipo.getText()));
		u.setEstado(Integer.parseInt(txtEstado.getText()));
		
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente");
		limpiar();
	}
	
	void actualizar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		Usuario u = em.find(Usuario.class, Integer.parseInt(txtCodigo.getText()));

		if(u != null) {
			u.setNombre(txtNombre.getText());
			u.setApellido(txtApellido.getText());
			u.setUsuario(txtUsuario.getText());
			u.setClave(txtClave.getText());
			u.setFnacim(txtFecha.getText());
			u.setTipo(Integer.parseInt(txtTipo.getText()));
			u.setEstado(Integer.parseInt(txtEstado.getText()));

			em = fabrica.createEntityManager();
			em.getTransaction().begin();
			u = em.merge(u);
			em.getTransaction().commit();
		}else {
			JOptionPane.showMessageDialog(this, "Usuario no existe");
			limpiar();
		}
		
		em.close();
		fabrica.close();
	}
	
	void eliminar() {
		EntityManagerFactory fabrica= Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		Usuario u = em.find(Usuario.class, Integer.parseInt(txtCodigo.getText()));
		if (u !=null) {
	
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
			JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente");
		} else {
			JOptionPane.showMessageDialog(this, "Usuario no existe");
			limpiar();	
		}
		em.close();
		fabrica.close();
	}
	
	void limpiar(){
		txtCodigo.setText("");	
		txtNombre.setText("");		
		txtApellido.setText("");
		txtUsuario.setText("");
		txtClave.setText("");
		txtFecha.setText("");
		txtTipo.setText("");
		txtEstado.setText("");
		
		txtCodigo.requestFocus();
	}
	
}
















