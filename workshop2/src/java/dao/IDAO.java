/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author AnataArisa
 */
public interface IDAO<T> {
    public List<T> getAll();
    public T create(T data);
    public T read(T data);
    public T update(T data);
    public T delete(T data);
}
